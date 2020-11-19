package ar.edu.ues21.algarrobo.admissioneventservice.service;

import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.EnrollmentEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.EventBase;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.StudentRecordEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.UserContactEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.repository.ResendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    public ResendService(ResendRepository resendRepository, ProducerService producerService) {
        this.resendRepository = resendRepository;
        this.producerService = producerService;
    }

    public void saveEventToResend(String topicName, EventBase event) {
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
        pendingEvents.forEach(eventBase ->
                producerService.sendStudentRecordEvent(
                        ((StudentRecordEvent) eventBase).getData(),
                        eventBase.getEventType(),
                        eventBase.getSource()));
    }

    public List<String> getUserContactPendingEvents() {
        return resendRepository.getEventsFromMap(USER_CONTACT_TOPIC, UserContactEvent.class)
                .stream()
                .map(EventBase::getEventId)
                .collect(Collectors.toList());
    }

    public void resendPendingUserContactEvents() {
        List<EventBase> pendingEvents = resendRepository.getEventsFromMap(USER_CONTACT_TOPIC, UserContactEvent.class);
        pendingEvents.forEach(eventBase ->
                producerService.sendUserContactEvent(
                        ((UserContactEvent) eventBase).getData(),
                        eventBase.getEventType(),
                        eventBase.getSource()));
    }

    public List<String> getAdmissionPendingEvents() {
        return resendRepository.getEventsFromMap(ADMISSION_PREENROLLMENT_TOPIC, EnrollmentEvent.class)
                .stream()
                .map(EventBase::getEventId)
                .collect(Collectors.toList());
    }

    public void resendPendingAdmissionEvents() {
        List<EventBase> pendingEvents = resendRepository.getEventsFromMap(ADMISSION_PREENROLLMENT_TOPIC, EnrollmentEvent.class);
        pendingEvents.forEach(eventBase ->
                producerService.sendEnrollmentEvent(
                        ((EnrollmentEvent) eventBase).getData(),
                        eventBase.getEventType(),
                        eventBase.getSource()));
    }
}
