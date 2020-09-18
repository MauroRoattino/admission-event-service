package ar.edu.ues21.algarrobo.admissioneventservice.engine;

import ar.edu.ues21.algarrobo.admissioneventservice.model.*;
import org.apache.catalina.Cluster;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

@Component
public class ProducerEngine {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerEngine.class);

    @Value("${kafka.topic.admission.pre_enrollment}")
    private String ADMISSION_PREENROLLMENT_TOPIC;



    @Value("${kafka.topic.academic_life.student-record}")
    private String STUDENT_RECORD_TOPIC;


    @Value("${kafka.topic.user.contact}")
    private String USER_CONTACT_TOPIC;

    private final Producer<String, EnrollmentEvent> enrollmentEventProducer;
    private final Producer<String, UserContactEvent> userContactEventProducer;
    private final Producer<String, StudentRecordEvent> studentRecordEventProducer;

    @Autowired
    public ProducerEngine(Producer<String, EnrollmentEvent> enrollmentEventProducer,
                          Producer<String, UserContactEvent> userContactEventProducer,
                          Producer<String, StudentRecordEvent> studentRecordEventProducer) {
        this.enrollmentEventProducer = enrollmentEventProducer;
        this.userContactEventProducer = userContactEventProducer;
        this.studentRecordEventProducer = studentRecordEventProducer;
    }

    private void sendMessage(Producer producer, String topic, EventBase eventBase) {

        producer.send(new ProducerRecord<>(topic, eventBase), (metadata, exception) -> {
            if (exception != null) {
                exception.printStackTrace();
            } else {
                LOGGER.info("Produced record to topic {} partition [{}] @ offset {}.",
                        metadata.topic(), metadata.partition(), metadata.offset());
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
