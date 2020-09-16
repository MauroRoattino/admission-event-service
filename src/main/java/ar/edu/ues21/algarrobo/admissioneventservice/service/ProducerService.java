package ar.edu.ues21.algarrobo.admissioneventservice.service;

import ar.edu.ues21.algarrobo.admissioneventservice.client.admissionapi.AdmissionClient;
import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.*;
import ar.edu.ues21.algarrobo.admissioneventservice.engine.ProducerEngine;
import ar.edu.ues21.algarrobo.admissioneventservice.model.ClusterResponseMetadata;
import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Enrollment;
import ar.edu.ues21.algarrobo.admissioneventservice.model.EnrollmentEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.StudentRecordEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.User.UserData;
import ar.edu.ues21.algarrobo.admissioneventservice.model.UserContactEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.AcademicLifeStudentRecord;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class ProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    @Value("${kafka.topic.admission.pre_enrollment}")
    private String preEnrollmentTopic;

    private static final List<ContactOrigin> ORIGIN_MASSIVE =  List.of(ContactOrigin.builder().id(ContactOriginId.builder().origin(39l).build()).build());
    private static final List<ContactOrigin> ORIGIN_ECOMMERCE = List.of(ContactOrigin.builder().id(ContactOriginId.builder().origin(38l).build()).build());

    private final ProducerEngine producerEngine;
    private final AdmissionClient admissionClient;

    @Autowired
    public ProducerService(ProducerEngine producerEngine, AdmissionClient admissionClient) {
        this.producerEngine = producerEngine;
        this.admissionClient = admissionClient;
    }


    public DeferredResult<ResponseEntity<ClusterResponseMetadata>> sendEnrollmentEvent(
            Enrollment enrollmentResponse, String eventType, String source) {
        this.processEnrollmentEvent(enrollmentResponse);
        EnrollmentEvent enrollmentEvent = new EnrollmentEvent(enrollmentResponse, eventType, source);
        return producerEngine.sendEnrollmentEvent(enrollmentEvent);
    }

    public void sendManyAdmissionEvents(List<Enrollment> enrollments, String eventType, String source) {
        for (Enrollment enrollment : enrollments) {
            sendEnrollmentEvent(enrollment, eventType, source);
        }
    }

    public DeferredResult<ResponseEntity<ClusterResponseMetadata>> sendUserContactEvent(
            UserData userData, String evenType, String source) {
        UserContactEvent userContactEvent = new UserContactEvent(userData, evenType, source);
        return producerEngine.sendUserContactEvent(userContactEvent);
    }

    public void sendManyUserContactEvents(List<UserData> userContactList, String eventType, String source) {
        for (UserData userContact : userContactList) {
            this.sendUserContactEvent(userContact, eventType, source);
        }
    }

    public DeferredResult<ResponseEntity<ClusterResponseMetadata>> sendStudentRecordEvent(
            AcademicLifeStudentRecord studentRecord, String eventType, String source) {
        StudentRecordEvent studentRecordEvent = new StudentRecordEvent(studentRecord, eventType, source);
        return producerEngine.sendStudentRecordEvent(studentRecordEvent);
    }

    public void sendManyStudentRecordEvents(List<AcademicLifeStudentRecord> studentRecordList, String eventType, String source) {
        for (AcademicLifeStudentRecord studentRecord : studentRecordList) {
            this.sendStudentRecordEvent(studentRecord, eventType, source);
        }
    }

    private void processEnrollmentEvent(Enrollment enrollmentEvent) {
        for (var ticket : enrollmentEvent.getTickets()) {
            ticket.setValorBruto(0.0);
            ticket.setPriceId(0L);
        }
        Student student = enrollmentEvent.getStudentRecord().getStudent();


        Contact contact = student.getContact();

        if (enrollmentEvent.isMassive()) {
            contact.setOrigin(ORIGIN_MASSIVE);
        } else {
            contact.setOrigin(ORIGIN_ECOMMERCE);
        }

        contact.getAddresses().stream()
                .filter(a -> a.getLocationRef() == null && a.getLocationId() != null).parallel().forEach(address -> {
            try {

                var rep = amissionClient.getLocation(address.getLocationId()).execute();
                if (rep.isSuccessful()) {
                    Location locationRef = rep.body();
                    address.setLocationRef(locationRef);
                }
            } catch (Exception e) {
                LOGGER.error(
                        "Contact Address Location INVALID : " + enrollmentEvent.getStudentRecord().getId());
            }

        });
    }    
}
