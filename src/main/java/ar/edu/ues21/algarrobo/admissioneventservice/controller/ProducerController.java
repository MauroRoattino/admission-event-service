package ar.edu.ues21.algarrobo.admissioneventservice.controller;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Enrollment;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.AcademicLifeStudentRecord;
import ar.edu.ues21.algarrobo.admissioneventservice.model.User.UserData;
import ar.edu.ues21.algarrobo.admissioneventservice.service.ProducerService;
import io.swagger.annotations.*;

import java.util.List;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity sendAdmissionEvent(
            @RequestBody Enrollment enrollmentEvent,
            @RequestHeader(value = "eventType", defaultValue = "pre-enrollment-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {
        LOGGER.info("Sending message");
        producerService.sendEnrollmentEvent(enrollmentEvent, eventType, source);
        return ResponseEntity.ok("Pre enrollment event sent");
    }

    @PreAuthorize("#oauth2.hasScope('admission-publish:write')")
    @ApiOperation(value = "Asynchronously send a list of pre-enrollment events to Kafka cluster", response = RecordMetadata.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Messages sent")})
    @PostMapping(value = "/sendManyAdmissionEvents")
    public ResponseEntity sendManyAdmissionEvents(
            @RequestBody List<Enrollment> enrollmentList,
            @RequestHeader(value = "eventType", defaultValue = "pre-enrollment-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {

        LOGGER.info("Sending {} administration pre-enrollment events to Kafka", enrollmentList.size());
        producerService.sendManyAdmissionEvents(enrollmentList, eventType, source);
        return ResponseEntity.ok("Messages sent");
    }

    @PreAuthorize("#oauth2.hasScope('student-record-publish:write')")
    @ApiOperation(value = "Send a student-record event to Kafka cluster", response = RecordMetadata.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message sent")
    })
    @PostMapping(value = "/sendStudentRecordEvent/")
    public ResponseEntity sendStudentRecordEvent(
            @RequestBody AcademicLifeStudentRecord studentRecord,
            @RequestHeader(value = "eventType", defaultValue = "student-record-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {
        LOGGER.info("Sending student-record event");
        producerService.sendStudentRecordEvent(studentRecord, eventType, source);
        return ResponseEntity.ok("Student record event sent");
    }

    @PreAuthorize("#oauth2.hasScope('student-record-publish:write')")
    @ApiOperation(value = "Asynchronously send a list of student record events to Kafka cluster", response = RecordMetadata.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Messages sent")})
    @PostMapping(value = "/sendManyStudentRecordEvents")
    public ResponseEntity sendManyStudentRecordEvents(
            @RequestBody List<AcademicLifeStudentRecord> studentRecordList,
            @RequestHeader(value = "eventType", defaultValue = "student-record-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {

        LOGGER.info("Sending {} studentRecord events to Kafka", studentRecordList.size());
        producerService.sendManyStudentRecordEvents(studentRecordList, eventType, source);
        return ResponseEntity.ok("Messages sent");
    }

    @PreAuthorize("#oauth2.hasScope('contact-publish:write')")
    @ApiOperation(value = "Send a user contact event to Kafka cluster", response = RecordMetadata.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message sent")
    })
    @PostMapping(value = "/sendUserContactEvent/")
    public ResponseEntity sendUserContactEvent(
            @RequestBody UserData contact,
            @RequestHeader(value = "eventType", defaultValue = "contact-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {
        LOGGER.info("Sending message");
        producerService.sendUserContactEvent(contact, eventType, source);
        return ResponseEntity.ok("Contact event sent");
    }

    @PreAuthorize("#oauth2.hasScope('contact-publish:write')")
    @ApiOperation(value = "Asynchronously send a list of user contact events to Kafka cluster", response = RecordMetadata.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Messages sent")})
    @PostMapping(value = "/sendManyUserContactEvents")
    public ResponseEntity sendManyUserContactEvents(
            @RequestBody List<UserData> userContacts,
            @RequestHeader(value = "eventType", defaultValue = "contact-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {

        LOGGER.info("Sending {} user-contact events to Kafka", userContacts.size());
        producerService.sendManyUserContactEvents(userContacts, eventType, source);
        return ResponseEntity.ok("Messages sent");
    }
}
