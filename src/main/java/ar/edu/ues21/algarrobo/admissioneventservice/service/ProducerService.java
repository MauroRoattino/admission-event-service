package ar.edu.ues21.algarrobo.admissioneventservice.service;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Enrollment;
import ar.edu.ues21.algarrobo.admissioneventservice.model.EnrollmentEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class ProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    @Value("${kafka.topic.admission.pre_enrollment}")
    private String preEnrollmentTopic;

    private final KafkaTemplate<String, EnrollmentEvent> enrollmentEventKafkaTemplate;

    @Autowired
    public ProducerService(KafkaTemplate<String, EnrollmentEvent> enrollmentEventKafkaTemplate) {
        this.enrollmentEventKafkaTemplate = enrollmentEventKafkaTemplate;
    }

    public DeferredResult<ResponseEntity<EnrollmentEvent>> sendEnrollmentEvent(
            Enrollment enrollmentResponse, String eventType) {

        EnrollmentEvent enrollmentEvent = new EnrollmentEvent(eventType, enrollmentResponse);

        ListenableFuture<SendResult<String, EnrollmentEvent>> future = enrollmentEventKafkaTemplate.send(preEnrollmentTopic, enrollmentEvent);

        final DeferredResult<ResponseEntity<EnrollmentEvent>> result = new DeferredResult<>();

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, EnrollmentEvent> response) {
                System.out.println("Sent [" + enrollmentEvent.getEventType() +
                        "] in topic=[" + response.getRecordMetadata().topic() +
                        "] to partition=[" + response.getRecordMetadata().partition() +
                        "] with offset=[" + response.getRecordMetadata().offset() +
                        "] and timestamp=[" + response.getRecordMetadata().timestamp() + "]");
                        
                result.setResult(ResponseEntity.ok(enrollmentEvent));
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send enrollment event due to : " + ex.getMessage());
                result.setErrorResult(ex);
            }
        });
        return result;
    }
}
