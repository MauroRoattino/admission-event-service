package ar.edu.ues21.algarrobo.admissioneventservice.service;

import ar.edu.ues21.algarrobo.admissioneventservice.client.nggBatchJobsApi.NggBatchJobsClient;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.CallbackRequest;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.ClusterResponseMetadata;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.EventBase;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.util.Objects;

@Service
public class CallbackService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CallbackService.class);

    private final NggBatchJobsClient nggBatchJobsClient;

    @Autowired
    public CallbackService(NggBatchJobsClient nggBatchJobsClient) {
        this.nggBatchJobsClient = nggBatchJobsClient;
    }

    public <T extends EventBase> void sendCallbackMessage(T eventBase, RecordMetadata metadata, Exception exception) {
        CallbackRequest callback = new CallbackRequest(eventBase.getEventId(),
                eventBase.getEventType(),
                Objects.nonNull(metadata) ? new ClusterResponseMetadata(metadata) : null,
                Objects.nonNull(exception) ? exception.getMessage() : "");

        if (eventBase.getSource().equals("ngg-batch-jobs")) {
            sendCallbackToNggBatchJobs(callback);
        }
    }

    private void sendCallbackToNggBatchJobs(CallbackRequest callbackRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CallbackRequest> entity = new HttpEntity<>(callbackRequest, headers);

        try {
            Call<Void> callAsync = nggBatchJobsClient.sendCallback(callbackRequest);
            callAsync.execute();
        } catch (Exception e) {
            LOGGER.error("Error while sending callback to ngg-batch-jobs of event with id: {}\n, Error: {}\n", callbackRequest.getId(), e.getMessage());
        }
    }
}
