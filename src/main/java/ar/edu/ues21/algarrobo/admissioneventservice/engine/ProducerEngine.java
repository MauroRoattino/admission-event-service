package ar.edu.ues21.algarrobo.admissioneventservice.engine;

import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.*;
import ar.edu.ues21.algarrobo.admissioneventservice.service.CallbackService;
import ar.edu.ues21.algarrobo.admissioneventservice.service.ResendService;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerEngine {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerEngine.class);

    @Value("${kafka.topic.admission.pre_enrollment}")
    private String ADMISSION_PREENROLLMENT_TOPIC;

    @Value("${kafka.topic.academic_life.student-record}")
    private String STUDENT_RECORD_TOPIC;

    @Value("${kafka.topic.user.contact}")
    private String USER_CONTACT_TOPIC;

    @Value("${kafka.topic.assessment.report}")
    private String ASSESSMENT_REPORT_TOPIC;

    @Value("${kafka.topic.assessment.subscriptGroup}")
    private String ASSESSMENT_SUBSCRIPTGROUP_TOPIC;

    private final Producer<String, EnrollmentEvent> enrollmentEventProducer;
    private final Producer<String, UserContactEvent> userContactEventProducer;
    private final Producer<String, StudentRecordEvent> studentRecordEventProducer;
    private final Producer<String, AssessmentReportEvent> assessmentReportEventProducer;
    private final Producer<String, SubscriptGroupEvent> subscriptGroupEventProducer;
    private final CallbackService callbackService;
    private final ResendService resendService;

    @Autowired
    public ProducerEngine(Producer<String, EnrollmentEvent> enrollmentEventProducer,
                          Producer<String, UserContactEvent> userContactEventProducer,
                          Producer<String, StudentRecordEvent> studentRecordEventProducer,
                          Producer<String, AssessmentReportEvent> assessmentReportEventProducer,
                          Producer<String, SubscriptGroupEvent> subscriptGroupEventProducer,
                          CallbackService callbackService,
                          ResendService resendService) {
        this.enrollmentEventProducer = enrollmentEventProducer;
        this.userContactEventProducer = userContactEventProducer;
        this.studentRecordEventProducer = studentRecordEventProducer;
        this.assessmentReportEventProducer = assessmentReportEventProducer;
        this.subscriptGroupEventProducer = subscriptGroupEventProducer;
        this.callbackService = callbackService;
        this.resendService = resendService;
    }

    private <T extends EventBase> void sendMessage(Producer<String, T> producer, String topic, T eventBase) {
        Boolean resendsActive = resendService.isTopicResendActive(topic);

        if (resendsActive) {
            resendService.deleteEventFromResendIfPending(topic, eventBase.getEventId());
        }

        producer.send(new ProducerRecord<>(topic, eventBase.getEventId(), eventBase), (metadata, exception) -> {
                callbackService.sendCallbackMessage(eventBase, metadata, exception);
            if (exception != null) {
                LOGGER.error("Encounter an error while sending event to kafka - EventId: {} - Error: {}",
                        eventBase.getEventId(), exception.getMessage());
                if (resendsActive) resendService.saveEventToResend(topic, eventBase);
            } else {
                LOGGER.info("Succesfully sended event of eventId {} to topic {} partition [{}] @ offset {}",
                        eventBase.getEventId(), metadata.topic(), metadata.partition(), metadata.offset());
            }
        });
    }

    public void sendEnrollmentEvent(EnrollmentEvent enrollmentEvent) {
        this.sendMessage(enrollmentEventProducer, ADMISSION_PREENROLLMENT_TOPIC, enrollmentEvent);
    }

    public void sendUserContactEvent(UserContactEvent userContactEvent) {
        this.sendMessage(userContactEventProducer, USER_CONTACT_TOPIC, userContactEvent);
    }

    public void sendStudentRecordEvent(
            StudentRecordEvent studentRecordEvent) {
        this.sendMessage(studentRecordEventProducer, STUDENT_RECORD_TOPIC, studentRecordEvent);
    }

    public void sendAssessmentReportEvent(
            AssessmentReportEvent assessmentReportEvent) {
        this.sendMessage(assessmentReportEventProducer, ASSESSMENT_REPORT_TOPIC, assessmentReportEvent);
    }

    public void sendSubscriptGroupEvent(SubscriptGroupEvent subscriptGroupEvent){
        this.sendMessage(subscriptGroupEventProducer, ASSESSMENT_SUBSCRIPTGROUP_TOPIC, subscriptGroupEvent);
    }
}
