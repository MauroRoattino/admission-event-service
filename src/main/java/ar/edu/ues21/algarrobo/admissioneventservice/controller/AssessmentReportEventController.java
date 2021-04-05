package ar.edu.ues21.algarrobo.admissioneventservice.controller;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Report.AssessmentReport;
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

@Api(tags = "assessment.report")
@RestController
@RequestMapping("/v1")
public class AssessmentReportEventController {

    private final ProducerService producerService;
    private final ResendService resendService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentReportEventController.class);


    @Autowired
    public AssessmentReportEventController(ProducerService producerService, ResendService resendService) {
        this.producerService = producerService;
        this.resendService = resendService;
    }


    @PreAuthorize("#oauth2.hasScope('assessment-report-publish:write')")
    @ApiOperation(value = "Asynchronously send a assessment report to Kafka Topic \"assessment.report\"",
            notes = "The model that is produced to Kafka is \"AssessmentReportEvent\"",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message sent")
    })
    @PostMapping(value = "/events/assessmentReport")
    public ResponseEntity<String> sendAssessmentReport(
            @RequestBody AssessmentReport assessmentReport,
            @RequestHeader(value = "eventType", defaultValue = "assessment-report-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {
        LOGGER.info("Sending assessment report event");
        producerService.sendAssessmentReportEvent(assessmentReport, eventType, source);
        return ResponseEntity.ok("Assessment report event sent");
    }

    @PreAuthorize("#oauth2.hasScope('assessment-report-publish:read')")
    @ApiOperation(value = "Get assessment-report-events pending to be sended Kafka", response = String[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Messages sent")
    })
    @GetMapping(value = "events/assessmentReport/resend")
    public ResponseEntity<List<String>> getPendingAssessmentReportEvent() {
        LOGGER.info("Getting pending assessment-report events");
        return ResponseEntity.ok(resendService.getAssessmentReportPendingEvents());
    }

    @PreAuthorize("#oauth2.hasScope('assessment-report-publish:write')")
    @ApiOperation(value = "Send pending assessment-report events to Kafka",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Messages sent")
    })
    @PostMapping(value = "events/assessmentReport/resend")
    public ResponseEntity<String> sendPendingAssessmentReportEvent() {
        LOGGER.info("Sending pending assesment-report events");
        resendService.resendPendingAssessmentReportEvents();
        return ResponseEntity.ok("Pending Assessment report event sent");
    }

}
