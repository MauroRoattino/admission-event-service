package ar.edu.ues21.algarrobo.admissioneventservice.controller;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Enrollment;
import ar.edu.ues21.algarrobo.admissioneventservice.model.User.UserContact;
import ar.edu.ues21.algarrobo.admissioneventservice.model.ClusterResponseMetadata;
import ar.edu.ues21.algarrobo.admissioneventservice.model.EnrollmentEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.AcademicLifeStudentRecord;
import ar.edu.ues21.algarrobo.admissioneventservice.service.ProducerService;
import io.swagger.annotations.*;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

@Api(tags = "Producer")
@RestController
@RequestMapping("/v1")
public class ProducerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerController.class);

    private final ProducerService producerService;

    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PreAuthorize("#oauth2.hasScope('admission-publish:write')")
    @ApiOperation(value = "Send a pre-enrollment event to Kafka cluster", response = RecordMetadata.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message sent")
    })
    @PostMapping(value = "/sendPreEnrollmentEvent/")
    public DeferredResult<ResponseEntity<ClusterResponseMetadata>> sendAdmissionEvent(
            @RequestBody Enrollment enrollmentEvent,
            @RequestHeader(value = "eventType", defaultValue = "pre-enrollment-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {
        LOGGER.info("Sending message");
        return producerService.sendEnrollmentEvent(enrollmentEvent, eventType, source);
    }
    
    @PreAuthorize("#oauth2.hasScope('student-record-publish:write')")
    @ApiOperation(value = "Send a student-record event to Kafka cluster", response = RecordMetadata.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message sent")
    })
    @PostMapping(value = "/sendStudentRecordEvent/")
    public DeferredResult<ResponseEntity<ClusterResponseMetadata>> sendStudentRecordEvent(
            @RequestBody AcademicLifeStudentRecord studentRecord,
            @RequestHeader(value = "eventType", defaultValue = "student-record-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {
        LOGGER.info("Sending student-record event");
        return producerService.sendStudentRecordEvent(studentRecord, eventType, source);
    }
    
    
    @PreAuthorize("#oauth2.hasScope('contact-publish:write')")
    @ApiOperation(value = "Send a user contact event to Kafka cluster", response = RecordMetadata.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message sent")
    })
    @PostMapping(value = "/sendUserContactEvent/")
    public DeferredResult<ResponseEntity<ClusterResponseMetadata>> sendUserContactEvent(
            @RequestBody UserContact contact,
            @RequestHeader(value = "eventType", defaultValue = "contact-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {
        LOGGER.info("Sending message");
        return producerService.sendUserContactEvent(contact, eventType, source);
    }
}
