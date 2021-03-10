package ar.edu.ues21.algarrobo.admissioneventservice.service;

import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.EnrollmentEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.EventBase;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.StudentRecordEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.UserContactEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.repository.ResendRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResendService {

    private final ResendRepository resendRepository;

    private final ProducerService producerService;

    @Value("${kafka.topic.admission.pre_enrollment}")
    private String ADMISSION_PREENROLLMENT_TOPIC;

    @Value("${kafka.topic.academic_life.student-record}")
    private String STUDENT_RECORD_TOPIC;

    @Value("${kafka.topic.user.contact}")
    private String USER_CONTACT_TOPIC;

    private static final Logger LOGGER = LoggerFactory.getLogger(ResendService.class);

    @Autowired
    public ResendService(ResendRepository resendRepository, @Lazy ProducerService producerService) {
        this.resendRepository = resendRepository;
        this.producerService = producerService;
    }

    public void saveEventToResend(String topicName, EventBase event) {
        LOGGER.warn("Saving event of eventId: {} for resend later", event.getEventId());
        resendRepository.addEventToMap(topicName, event.getEventId(), event);
    }

    public void deleteEventFromResendIfPending(String topicName, String eventId) {
        resendRepository.deleteEventFromMapIfExists(topicName, eventId);
    }

    public List<String> getStudentRecordPendingEvents() {
        return resendRepository.getEventsFromMap(STUDENT_RECORD_TOPIC, StudentRecordEvent.class)
                .stream()
                .map(EventBase::getEventId)
                .collect(Collectors.toList());
    }

    public void resendPendingStudentRecordEvents() {
        List<EventBase> pendingEvents = resendRepository.getEventsFromMap(STUDENT_RECORD_TOPIC, StudentRecordEvent.class);
        pendingEvents.forEach(eventBase -> {
                LOGGER.info("RESEND - Resending event with ID = {} to topic = {}", eventBase.getEventId(), STUDENT_RECORD_TOPIC);
                producerService.sendStudentRecordEvent(
                        ((StudentRecordEvent) eventBase).getData(),
                        eventBase.getEventType(),
                        eventBase.getSource());
        });
    }

    public List<String> getUserContactPendingEvents() {
        return resendRepository.getEventsFromMap(USER_CONTACT_TOPIC, UserContactEvent.class)
                .stream()
                .map(EventBase::getEventId)
                .collect(Collectors.toList());
    }

    public void resendPendingUserContactEvents() {
        List<EventBase> pendingEvents = resendRepository.getEventsFromMap(USER_CONTACT_TOPIC, UserContactEvent.class);
        pendingEvents.forEach(eventBase -> {
                LOGGER.info("RESEND - Resending event with ID = {} to topic = {}", eventBase.getEventId(), USER_CONTACT_TOPIC);
                producerService.sendUserContactEvent(
                        ((UserContactEvent) eventBase).getData(),
                        eventBase.getEventType(),
                        eventBase.getSource());
        });
    }

    public List<String> getAdmissionPendingEvents() {
        return resendRepository.getEventsFromMap(ADMISSION_PREENROLLMENT_TOPIC, EnrollmentEvent.class)
                .stream()
                .map(EventBase::getEventId)
                .collect(Collectors.toList());
    }

    public void resendPendingAdmissionEvents() {
        List<EventBase> pendingEvents = resendRepository.getEventsFromMap(ADMISSION_PREENROLLMENT_TOPIC, EnrollmentEvent.class);
        pendingEvents.forEach(eventBase -> {
            LOGGER.info("RESEND - Resending event with ID = {} to topic = {}", eventBase.getEventId(), ADMISSION_PREENROLLMENT_TOPIC);
            producerService.sendEnrollmentEvent(
                    ((EnrollmentEvent) eventBase).getData(),
                    eventBase.getEventType(),
                    eventBase.getSource());
        });
    }
}
