package ar.edu.ues21.algarrobo.admissioneventservice.service;

import ar.edu.ues21.algarrobo.admissioneventservice.client.admissionapi.AdmissionClient;
import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.*;
import ar.edu.ues21.algarrobo.admissioneventservice.engine.ProducerEngine;
import ar.edu.ues21.algarrobo.admissioneventservice.model.EnrollmentEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.StudentRecordEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.User.UserData;
import ar.edu.ues21.algarrobo.admissioneventservice.model.UserContactEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.AcademicLifeStudentRecord;

import java.util.List;

import com.google.common.base.Strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    @Value("${kafka.topic.admission.pre_enrollment}")
    private String preEnrollmentTopic;

    private static final String ORIGIN_MASSIVE = "39";
    private static final String ORIGIN_ECOMERCE = "38";

    private final ProducerEngine producerEngine;
    private final AdmissionClient admissionClient;

    @Autowired
    public ProducerService(ProducerEngine producerEngine, AdmissionClient admissionClient) {
        this.producerEngine = producerEngine;
        this.admissionClient = admissionClient;
    }

    public void sendEnrollmentEvent(Enrollment enrollmentResponse, String eventType, String source) {
        this.processEnrollmentEvent(enrollmentResponse);
        EnrollmentEvent enrollmentEvent = new EnrollmentEvent(enrollmentResponse, eventType, source);
        producerEngine.sendEnrollmentEvent(enrollmentEvent);
    }

    public void sendManyAdmissionEvents(List<Enrollment> enrollments, String eventType, String source) {
        for (Enrollment enrollment : enrollments) {
            sendEnrollmentEvent(enrollment, eventType, source);
        }
    }

    public void sendUserContactEvent(UserData userData, String evenType, String source) {
        UserContactEvent userContactEvent = new UserContactEvent(userData, evenType, source);
        producerEngine.sendUserContactEvent(userContactEvent);
    }

    public void sendManyUserContactEvents(List<UserData> userContactList, String eventType, String source) {
        for (UserData userContact : userContactList) {
            this.sendUserContactEvent(userContact, eventType, source);
        }
    }

    public void sendStudentRecordEvent(AcademicLifeStudentRecord studentRecord, String eventType, String source) {
        StudentRecordEvent studentRecordEvent = new StudentRecordEvent(studentRecord, eventType, source);
        producerEngine.sendStudentRecordEvent(studentRecordEvent);
    }

    public void sendManyStudentRecordEvents(List<AcademicLifeStudentRecord> studentRecordList, String eventType,
            String source) {
        for (AcademicLifeStudentRecord studentRecord : studentRecordList) {
            this.sendStudentRecordEvent(studentRecord, eventType, source);
        }
    }

    private void processEnrollmentEvent(Enrollment enrollmentEvent) {
        if (enrollmentEvent.getTickets() != null) {

            for (var ticket : enrollmentEvent.getTickets()) {
                ticket.setValorBruto(0.0);
                ticket.setPriceId(0L);
            }
        }
        StudentRecord studentRecord = enrollmentEvent.getStudentRecord();
        Student student = studentRecord.getStudent();
        if (!Strings.isNullOrEmpty(student.getPrimaryEmail()) && Strings.isNullOrEmpty(student.getSecondaryEmail())) {
            // primary is set, secondary empty
            student.setSecondaryEmail(student.getPrimaryEmail());
        }
        if (!Strings.isNullOrEmpty(student.getSecondaryEmail()) && Strings.isNullOrEmpty(student.getPrimaryEmail())) {
            // secondary is set, primary empty
            student.setPrimaryEmail(student.getSecondaryEmail());
        }

        if (Strings.isNullOrEmpty(student.getPrimaryEmail()) && Strings.isNullOrEmpty(student.getSecondaryEmail())) {
            student.setPrimaryEmail("no@tiene.email.com");
            student.setSecondaryEmail("no@tiene.email.com");
        }

        Contact contact = student.getContact();

        if (!Strings.isNullOrEmpty(contact.getPrimaryEmail()) && Strings.isNullOrEmpty(contact.getSecondaryEmail())) {
            // primary is set, secondary empty
            contact.setSecondaryEmail(contact.getPrimaryEmail());
        }
        if (!Strings.isNullOrEmpty(contact.getSecondaryEmail()) && Strings.isNullOrEmpty(contact.getPrimaryEmail())) {
            // secondary is set, primary empty
            contact.setPrimaryEmail(contact.getSecondaryEmail());
        }

        if (Strings.isNullOrEmpty(contact.getPrimaryEmail()) && Strings.isNullOrEmpty(contact.getSecondaryEmail())) {
            contact.setPrimaryEmail("no@tiene.email.com");
            contact.setSecondaryEmail("no@tiene.email.com");
        }

        if (enrollmentEvent.isMassive()) {
            contact.setCrmSource(ORIGIN_MASSIVE);
            studentRecord.setStatus(5l); // hardcoded for crm;

        } else if (contact.getCrmSource() == null || contact.getCrmSource().length() == 0) {
            contact.setCrmSource(ORIGIN_ECOMERCE);
        }

        contact.getAddresses().stream().filter(a -> a.getLocationRef() == null && a.getLocationId() != null).parallel()
                .forEach(address -> {
                    try {

                        var rep = admissionClient.getLocation(address.getLocationId()).execute();
                        if (rep.isSuccessful()) {
                            Location locationRef = rep.body();
                            address.setLocationRef(locationRef);
                        }
                    } catch (Exception e) {
                        LOGGER.error("Contact Address Location INVALID : " + studentRecord.getId());
                    }

                });
    }
}
