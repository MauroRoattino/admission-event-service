package ar.edu.ues21.algarrobo.admissioneventservice.controller;

import ar.edu.ues21.algarrobo.admissioneventservice.model.User.UserData;
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

@Api(tags = "User Contact Event Controller")
@RestController
@RequestMapping("/v1")
public class UserContactEventController {

    private final ProducerService producerService;

    private final ResendService resendService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserContactEventController.class);


    @Autowired
    public UserContactEventController(ProducerService producerService, ResendService resendService) {
        this.producerService = producerService;
        this.resendService = resendService;
    }

    @Deprecated(forRemoval = true)
    @PreAuthorize("#oauth2.hasScope('contact-publish:write')")
    @ApiOperation(value = "Send a user contact event to Kafka cluster", response = RecordMetadata.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message sent")
    })
    @PostMapping(value = "/sendUserContactEvent/")
    public ResponseEntity<String> sendUserContactEvent(
            @RequestBody UserData contact,
            @RequestHeader(value = "eventType", defaultValue = "contact-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {
        LOGGER.info("Sending message");
        producerService.sendUserContactEvent(contact, eventType, source);
        return ResponseEntity.ok("Contact event sent");
    }

    @PreAuthorize("#oauth2.hasScope('contact-publish:write')")
    @ApiOperation(value = "Send a user contact event to Kafka cluster", response = RecordMetadata.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message sent")
    })
    @PostMapping(value = "/events/user-contact/{id}")
    public ResponseEntity<String> sendUserContactEventV2(
            @RequestBody UserData contact,
            @RequestHeader(value = "eventType", defaultValue = "contact-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source, @PathVariable String id) {
        LOGGER.info("Sending message");
        producerService.sendUserContactEvent(contact, eventType, source);
        return ResponseEntity.ok("Contact event sent");
    }

    @Deprecated(forRemoval = true)
    @PreAuthorize("#oauth2.hasScope('contact-publish:write')")
    @ApiOperation(value = "Asynchronously send a list of user contact events to Kafka cluster", response = RecordMetadata.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Messages sent")})
    @PostMapping(value = "/sendManyUserContactEvents")
    public ResponseEntity<String> sendManyUserContactEvents(
            @RequestBody List<UserData> userContacts,
            @RequestHeader(value = "eventType", defaultValue = "contact-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {

        LOGGER.info("Sending {} user-contact events to Kafka", userContacts.size());
        producerService.sendManyUserContactEvents(userContacts, eventType, source);
        return ResponseEntity.ok("Messages sent");
    }

    @PreAuthorize("#oauth2.hasScope('contact-publish:write')")
    @ApiOperation(value = "Asynchronously send a list of user contact events to Kafka cluster", response = RecordMetadata.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Messages sent")})
    @PostMapping(value = "/events/user-contact")
    public ResponseEntity<String> sendManyUserContactEventsV2(
            @RequestBody List<UserData> userContacts,
            @RequestHeader(value = "eventType", defaultValue = "contact-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {

        LOGGER.info("Sending {} user-contact events to Kafka", userContacts.size());
        producerService.sendManyUserContactEvents(userContacts, eventType, source);
        return ResponseEntity.ok("Messages sent");
    }

    @PreAuthorize("#oauth2.hasScope('contact-publish:read')")
    @ApiOperation(value = "Get user contact events pending to be sended Kafka")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Messages sent")
    })
    @GetMapping(value = "events/user-contact-event/resend")
    public ResponseEntity<List<String>> getPendingUserContactEvent() {
        LOGGER.info("Getting pending user contact events");
        return ResponseEntity.ok(resendService.getUserContactPendingEvents());
    }

    @PreAuthorize("#oauth2.hasScope('contact-publish:write')")
    @ApiOperation(value = "Send pending user contact events to Kafka")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Messages sent")
    })
    @PostMapping(value = "/events/user-contact-event/resend")
    public ResponseEntity<String> sendPendingUserContactEvent() {
        LOGGER.info("Sending pending user contact events");
        resendService.resendPendingUserContactEvents();
        return ResponseEntity.ok("Pending user contact event sent");
    }
}
