package ar.edu.ues21.algarrobo.admissioneventservice.engine;

import ar.edu.ues21.algarrobo.admissioneventservice.model.*;
import ar.edu.ues21.algarrobo.admissioneventservice.service.NggBatchJobsService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerEngine {
    @Value("${kafka.topic.admission.pre_enrollment}")
    private String ADMISSION_PREENROLLMENT_TOPIC;

    @Value("${kafka.topic.academic_life.student-record}")
    private String STUDENT_RECORD_TOPIC;

    @Value("${kafka.topic.user.contact}")
    private String USER_CONTACT_TOPIC;

    private final Producer<String, EnrollmentEvent> enrollmentEventProducer;
    private final Producer<String, UserContactEvent> userContactEventProducer;
    private final Producer<String, StudentRecordEvent> studentRecordEventProducer;
    private final NggBatchJobsService nggBatchJobsService;

    @Autowired
    public ProducerEngine(Producer<String, EnrollmentEvent> enrollmentEventProducer,
                          Producer<String, UserContactEvent> userContactEventProducer,
                          Producer<String, StudentRecordEvent> studentRecordEventProducer,
                          NggBatchJobsService nggBatchJobsService) {
        this.enrollmentEventProducer = enrollmentEventProducer;
        this.userContactEventProducer = userContactEventProducer;
        this.studentRecordEventProducer = studentRecordEventProducer;
        this.nggBatchJobsService = nggBatchJobsService;
    }

    private void sendMessage(Producer producer, String topic, EventBase eventBase) {
        String key = new DigestUtils("SHA3-256").digestAsHex(eventBase.getEventId());
        producer.send(new ProducerRecord<>(topic, key, eventBase), (metadata, exception) -> {
            if (exception != null) {
                ErrorEvent errorEvent = new ErrorEvent(eventBase.getEventId(), exception.getMessage());
                nggBatchJobsService.sendErrorCallback(errorEvent);
            }
        });
    }

    public void sendEnrollmentEvent(EnrollmentEvent enrollmentEvent) {
        this.sendMessage(enrollmentEventProducer, ADMISSION_PREENROLLMENT_TOPIC, enrollmentEvent);
    }

    public void sendUserContactEvent(
            UserContactEvent userContactEvent) {
        this.sendMessage(userContactEventProducer, USER_CONTACT_TOPIC, userContactEvent);
    }

    public void sendStudentRecordEvent(
            StudentRecordEvent studentRecordEvent) {
        this.sendMessage(studentRecordEventProducer, STUDENT_RECORD_TOPIC, studentRecordEvent);
    }
}
