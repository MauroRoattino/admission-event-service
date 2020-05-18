package ar.edu.ues21.algarrobo.admissioneventservice.controller;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Enrollment;
import ar.edu.ues21.algarrobo.admissioneventservice.model.EnrollmentEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.service.ProducerService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @ApiOperation(value = "Send a pre-enrollment event to MSK Cluster", response = EnrollmentEvent.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Message sent")})
    @PostMapping(value = "/sendPreEnrollmentEvent/")
    public DeferredResult<ResponseEntity<EnrollmentEvent>> sendAdmissionEvent(@RequestBody Enrollment enrollmentEvent,
                                                                              @RequestHeader(value = "eventType", defaultValue = "pre-enrollment-event") String eventType) {
        LOGGER.info("Sending message");
        return producerService.sendEnrollmentEvent(enrollmentEvent, eventType);
    }
}
