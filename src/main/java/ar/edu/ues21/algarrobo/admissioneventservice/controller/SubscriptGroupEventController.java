package ar.edu.ues21.algarrobo.admissioneventservice.controller;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Report.AssessmentReport;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.SubscriptGroup;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.SubscriptGroupEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.service.ProducerService;
import ar.edu.ues21.algarrobo.admissioneventservice.service.ResendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "assessment.group.subscription")
@RestController
@RequestMapping("/v1")
public class SubscriptGroupEventController {

    private final ProducerService producerService;
    private final ResendService resendService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptGroupEventController.class);

    @Autowired
    public SubscriptGroupEventController(ProducerService producerService, ResendService resendService) {
        this.producerService = producerService;
        this.resendService = resendService;
    }

    @PreAuthorize("#oauth2.hasScope('assessment-group-subscription-publish:write')")
    @ApiOperation(value = "Asynchronously send a subscript group event to Kafka Topic \"assessment.subscriptGroup\"",
            notes = "The model that is produced to Kafka is \"SubscriptGroupEvent\"",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message sent")
    })
    @PostMapping(value = "/events/assessments-groups/subscriptions")
    public ResponseEntity<SubscriptGroupEvent> sendAssessmentReport(
            @RequestBody SubscriptGroup subscriptGroup,
            @RequestHeader(value = "eventType", defaultValue = "subscript-group-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {
        LOGGER.info("Sending subscript group event");
        producerService.sendSubscriptGroupEvent(subscriptGroup, eventType, source);
        SubscriptGroupEvent event = new SubscriptGroupEvent(subscriptGroup, eventType, source);
        return ResponseEntity.ok(event);
    }

    @PreAuthorize("#oauth2.hasScope('assessment-group-subscription-publish:read')")
    @ApiOperation(value = "Get subscript-group pending to be sended Kafka", response = String[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Messages sent")
    })
    @GetMapping(value = "events/subscriptGroup/resend")
    public ResponseEntity<List<String>> getSubscriptGroupPendingEvents() {
        LOGGER.info("Getting pending subscript-group events");
        return ResponseEntity.ok(resendService.getSubscriptGroupPendingEvents());
    }

    @PreAuthorize("#oauth2.hasScope('assessment-group-subscription-publish:write')")
    @ApiOperation(value = "Send pending subscript-group events to Kafka",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Messages sent")
    })
    @PostMapping(value = "events/subscriptGroup/resend")
    public ResponseEntity<String> sendPendingAssessmentReportEvent() {
        LOGGER.info("Sending pending subscript-group events");
        resendService.resendSubscriptGroupPendingEvents();
        return ResponseEntity.ok("Pending Subscript Group event sent");
    }
}
