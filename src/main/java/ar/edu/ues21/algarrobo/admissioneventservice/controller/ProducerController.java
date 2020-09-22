package ar.edu.ues21.algarrobo.admissioneventservice.controller;

import ar.edu.ues21.algarrobo.admissioneventservice.client.admissionapi.AdmissionClient;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.AcademicLifeStudentRecord;
import ar.edu.ues21.algarrobo.admissioneventservice.model.ClusterResponseMetadata;
import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.*;
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
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@Api(tags = "Producer")
@RestController
@RequestMapping("/v1")
public class ProducerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerController.class);

    private final ProducerService producerService;

    private static final String ORIGIN_MASSIVE ="39";
    private static final String ORIGIN_ECOMERCE = "38";

    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @Autowired
    private AdmissionClient amissionClient;


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

        if (enrollmentEvent.getTickets() != null)
        for (var ticket : enrollmentEvent.getTickets()) {
            ticket.setValorBruto(0.0);
            ticket.setPriceId(0L);
        }
        Student student = enrollmentEvent.getStudentRecord().getStudent();


        Contact contact = student.getContact();

        if (enrollmentEvent.isMassive()) {
            contact.setCrmSource(ORIGIN_MASSIVE);
        } else if (contact.getCrmSource() == null || contact.getCrmSource().length() == 0) {
            contact.setCrmSource(ORIGIN_ECOMERCE);
        }

        contact.getAddresses().stream()
                .filter(a -> a.getLocationRef() == null && a.getLocationId() != null).parallel().forEach(address -> {
            try {

                var rep = amissionClient.getLocation(address.getLocationId()).execute();
                if (rep.isSuccessful()) {
                    Location locationRef = rep.body();
                    address.setLocationRef(locationRef);
                }
            } catch (Exception e) {
                LOGGER.error(
                        "Contact Address Location INVALID : " + enrollmentEvent.getStudentRecord().getId());
            }

        });

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
            @RequestBody UserData contact,
            @RequestHeader(value = "eventType", defaultValue = "contact-event") String eventType,
            @RequestHeader(value = "source", defaultValue = "-") String source) {
        LOGGER.info("Sending message");
        return producerService.sendUserContactEvent(contact, eventType, source);
    }
}
