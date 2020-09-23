package ar.edu.ues21.algarrobo.admissioneventservice.service;

import ar.edu.ues21.algarrobo.admissioneventservice.model.ErrorEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NggBatchJobsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NggBatchJobsService.class);

    private final RestTemplate restTemplate;

    @Value("${ngg-batch-jobs.baseurl}")
    private String baseUrl;

    @Autowired
    public NggBatchJobsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendErrorCallback(ErrorEvent errorEvent) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ErrorEvent> entity = new HttpEntity<>(errorEvent, headers);
        String nggBatchJobError = "/v1/jobs/migration/error";
        String response = restTemplate.patchForObject(baseUrl + nggBatchJobError, entity, String.class);

        if (response == null) {
            LOGGER.error("Error sending call back for event with id: {}", errorEvent.getId());
        } else {
            LOGGER.info("Error callback sent successfully");
        }
    }
}
