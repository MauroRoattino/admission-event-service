package ar.edu.ues21.algarrobo.admissioneventservice.service;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Enrollment;
import ar.edu.ues21.algarrobo.admissioneventservice.model.User.UserContact;
import ar.edu.ues21.algarrobo.admissioneventservice.engine.ProducerEngine;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicOfferEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.CauEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.ClusterResponseMetadata;
import ar.edu.ues21.algarrobo.admissioneventservice.model.EnrollmentEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.StudentRecordEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.TicketEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.UserContactEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.AcademicLifeStudentRecord;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicOffer.AcademicOffer;
import ar.edu.ues21.algarrobo.admissioneventservice.model.Administration.AdministrationTicket;
import ar.edu.ues21.algarrobo.admissioneventservice.model.Cau.Cau;

import java.util.List;

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

    private final ProducerEngine producerEngine;

    @Autowired
    public ProducerService(ProducerEngine producerEngine) {
        this.producerEngine = producerEngine;
    }

    public DeferredResult<ResponseEntity<ClusterResponseMetadata>> sendEnrollmentEvent(
            Enrollment enrollmentResponse, String eventType, String source) {
        EnrollmentEvent enrollmentEvent = new EnrollmentEvent(enrollmentResponse, eventType, source);
        return producerEngine.sendEnrollmentEvent(enrollmentEvent);
    }

    public void sendEnrollmentEvents(List<Enrollment> enrollments, String eventType, String source) {
        for (Enrollment enrollment : enrollments) {
            sendEnrollmentEvent(enrollment, eventType, source);
        }
    }

   

    public DeferredResult<ResponseEntity<ClusterResponseMetadata>> sendUserContactEvent(
            UserContact userContact, String evenType, String source) {
        UserContactEvent userContactEvent = new UserContactEvent(userContact, evenType, source);
        return producerEngine.sendUserContactEvent(userContactEvent);
    }

    public DeferredResult<ResponseEntity<ClusterResponseMetadata>> sendStudentRecordEvent(
            AcademicLifeStudentRecord studentRecord, String eventType, String source) {
        StudentRecordEvent studentRecordEvent = new StudentRecordEvent(studentRecord, eventType, source);
        return producerEngine.sendStudentRecordEvent(studentRecordEvent);
    }

  

}
