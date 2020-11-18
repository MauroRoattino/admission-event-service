package ar.edu.ues21.algarrobo.admissioneventservice.controller;

import ar.edu.ues21.algarrobo.admissioneventservice.model.User.UserData;
import ar.edu.ues21.algarrobo.admissioneventservice.service.ProducerService;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(UserContactEventController.class);


    @Autowired
    public UserContactEventController(ProducerService producerService) {
        this.producerService = producerService;
    }

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
}
