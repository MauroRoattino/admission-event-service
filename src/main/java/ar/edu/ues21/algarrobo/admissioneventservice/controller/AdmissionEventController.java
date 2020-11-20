package ar.edu.ues21.algarrobo.admissioneventservice.controller;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Enrollment;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.EnrollmentEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.service.ProducerService;
import ar.edu.ues21.algarrobo.admissioneventservice.service.ResendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Admission Event Controller")
@RestController
@RequestMapping("/v1")
public class AdmissionEventController {

    private final ProducerService producerService;

    private final ResendService resendService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdmissionEventController.class);


    @Autowired
    public AdmissionEventController(ProducerService producerService, ResendService resendService) {
        this.producerService = producerService;
        this.resendService = resendService;
    }

    @PreAuthorize("#oauth2.hasScope('admission-publish:write')")
    @ApiOperation(value = "Send a pre-enrollment event to Kafka cluster", response = RecordMetadata.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message sent")
    })
    @PostMapping(value = "/sendPreEnrollmentEvent/")
    public ResponseEntity<EnrollmentEvent> sendAdmissionEvent(
            @RequestBody Enrollment enrollmentEvent,
            @RequestHeader(value = "eventType", defaultValue = "pre-enrollment-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {
        LOGGER.info("Sending message");
        producerService.sendEnrollmentEvent(enrollmentEvent, eventType, source);
        EnrollmentEvent response = new EnrollmentEvent(enrollmentEvent, eventType, source);
        return ResponseEntity.ok(response);
    }


    @PreAuthorize("#oauth2.hasScope('admission-publish:write')")
    @ApiOperation(value = "Asynchronously send a list of pre-enrollment events to Kafka cluster", response = RecordMetadata.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Messages sent")})
    @PostMapping(value = "/sendManyAdmissionEvents")
    public ResponseEntity<String> sendManyAdmissionEvents(
            @RequestBody List<Enrollment> enrollmentList,
            @RequestHeader(value = "eventType", defaultValue = "pre-enrollment-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {

        LOGGER.info("Sending {} administration pre-enrollment events to Kafka", enrollmentList.size());
        producerService.sendManyAdmissionEvents(enrollmentList, eventType, source);
        return ResponseEntity.ok("Messages sent");
    }

    @PreAuthorize("#oauth2.hasScope('admission-publish:read')")
    @ApiOperation(value = "Get admission events pending to be sended Kafka")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Messages sent")
    })
    @GetMapping(value = "/admissionEvent/resend")
    public ResponseEntity<List<String>> getPendingAdmissionEvent() {
        LOGGER.info("Getting pending admission events");
        return ResponseEntity.ok(resendService.getAdmissionPendingEvents());
    }

    @PreAuthorize("#oauth2.hasScope('admission-publish:write')")
    @ApiOperation(value = "Send pending admission events to Kafka")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Messages sent")
    })
    @PostMapping(value = "/admissionEvent/resend")
    public ResponseEntity<String> sendPendingAdmissionEvent() {
        LOGGER.info("Sending pending student-record events");
        resendService.resendPendingAdmissionEvents();
        return ResponseEntity.ok("Pending admission event sent");
    }
}