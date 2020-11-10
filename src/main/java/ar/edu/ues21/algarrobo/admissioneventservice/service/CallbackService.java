package ar.edu.ues21.algarrobo.admissioneventservice.service;

import ar.edu.ues21.algarrobo.admissioneventservice.client.nggBatchJobsApi.NggBatchJobsClient;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.CallbackRequest;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.ClusterResponseMetadata;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.EventBase;
import com.sun.istack.Nullable;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.util.Objects;

@Service
public class CallbackService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CallbackService.class);

    private final NggBatchJobsClient nggBatchJobsClient;

    @Value("${callback.send-level}")
    private String callbackSendLevel;

    @Autowired
    public CallbackService(NggBatchJobsClient nggBatchJobsClient) {
        this.nggBatchJobsClient = nggBatchJobsClient;
    }

    public <T extends EventBase> void sendCallbackMessage(T eventBase, @Nullable RecordMetadata metadata, @Nullable Exception exception) {
        CallbackRequest callback = new CallbackRequest(eventBase.getEventId(),
                eventBase.getEventType(),
                Objects.nonNull(metadata) ? new ClusterResponseMetadata(metadata) : null,
                Objects.nonNull(exception) ? exception.getMessage() : "");

        switch (callbackSendLevel) {
            case "ALL":
                sendToSource(eventBase, callback);
                break;
            case "ERROR":
                if (Objects.nonNull(exception)) sendToSource(eventBase, callback);
                break;
            default:
                break;
        }

    }


    private void sendToSource(EventBase eventBase, CallbackRequest callback) {
        switch (eventBase.getSource()) {
            case "ngg-batch-jobs":
                sendCallbackToNggBatchJobs(callback);
                break;
            default:
                break;
        }
    }


    private void sendCallbackToNggBatchJobs(CallbackRequest callbackRequest) {
        try {
            Response<Void> response = nggBatchJobsClient.sendCallback(callbackRequest).execute();
            if (!response.isSuccessful()) {
                LOGGER.error("Error while sending callback to ngg-batch-jobs of event with id: {}\n, Error: {}\n",
                        callbackRequest.getId(), response.errorBody().string());
            }
        } catch (Exception e) {
            LOGGER.error("Error while sending callback to ngg-batch-jobs of event with id: {}\n, Error: {}\n", callbackRequest.getId(), e.getMessage());
        }
    }
}
