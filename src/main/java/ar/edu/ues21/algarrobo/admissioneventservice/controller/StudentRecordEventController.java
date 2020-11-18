package ar.edu.ues21.algarrobo.admissioneventservice.controller;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.AcademicLifeStudentRecord;
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

@Api(tags = "Student Record Event Controller")
@RestController
@RequestMapping("/v1")
public class StudentRecordEventController {

    private final ProducerService producerService;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentRecordEventController.class);


    @Autowired
    public StudentRecordEventController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PreAuthorize("#oauth2.hasScope('student-record-publish:write')")
    @ApiOperation(value = "Send a student-record event to Kafka cluster", response = RecordMetadata.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message sent")
    })
    @PostMapping(value = "/sendStudentRecordEvent/")
    public ResponseEntity<String> sendStudentRecordEvent(
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
    public ResponseEntity<String> sendManyStudentRecordEvents(
            @RequestBody List<AcademicLifeStudentRecord> studentRecordList,
            @RequestHeader(value = "eventType", defaultValue = "student-record-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {

        LOGGER.info("Sending {} studentRecord events to Kafka", studentRecordList.size());
        producerService.sendManyStudentRecordEvents(studentRecordList, eventType, source);
        return ResponseEntity.ok("Messages sent");
    }
}
