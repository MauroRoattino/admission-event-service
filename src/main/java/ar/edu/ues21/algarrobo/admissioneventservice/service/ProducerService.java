package ar.edu.ues21.algarrobo.admissioneventservice.service;

import ar.edu.ues21.algarrobo.admissioneventservice.client.admissionapi.AdmissionClient;
import ar.edu.ues21.algarrobo.admissioneventservice.engine.ProducerEngine;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.AcademicLifeStudentRecord;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Report.AssessmentReport;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Student.AcademicLifeStudent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.SubscriptGroup;
import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.*;
import ar.edu.ues21.algarrobo.admissioneventservice.model.User.UserAddress;
import ar.edu.ues21.algarrobo.admissioneventservice.model.User.UserData;
import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.*;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class ProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    @Value("${kafka.topic.admission.pre_enrollment}")
    private String preEnrollmentTopic;

    private static final String ORIGIN_MASSIVE = "39";
    private static final String ORIGIN_ECOMERCE = "38";

    private final ProducerEngine producerEngine;
    private final AdmissionClient admissionClient;

    private final String defaultEmail = "notengomail@ues21.edu.ar";

    @Autowired
    public ProducerService(ProducerEngine producerEngine, AdmissionClient admissionClient) {
        this.producerEngine = producerEngine;
        this.admissionClient = admissionClient;
    }

    @Async
    public void sendEnrollmentEvent(Enrollment enrollmentResponse, String eventType, String source) {
        this.processEnrollmentEvent(enrollmentResponse);
        EnrollmentEvent enrollmentEvent = new EnrollmentEvent(enrollmentResponse, eventType, source);
        producerEngine.sendEnrollmentEvent(enrollmentEvent);
    }

    @Async
    public void sendManyAdmissionEvents(List<Enrollment> enrollments, String eventType, String source) {
        for (Enrollment enrollment : enrollments) {
            sendEnrollmentEvent(enrollment, eventType, source);
        }
    }

    @Async
    public void sendAssessmentReportEvent(AssessmentReport data, String eventType, String source){
        AssessmentReportEvent assessmentReportEvent = new AssessmentReportEvent(data, eventType, source);
        producerEngine.sendAssessmentReportEvent(assessmentReportEvent);
    }

    @Async
    public void sendSubscriptGroupEvent(SubscriptGroup data, String eventType, String source){
        SubscriptGroupEvent subscriptGroupEvent = new SubscriptGroupEvent(data, eventType, source);
        producerEngine.sendSubscriptGroupEvent(subscriptGroupEvent);
    }

    @Async
    public void sendUserContactEvent(UserData userData, String evenType, String source) {
        UserContactEvent userContactEvent = new UserContactEvent(userData, evenType, source);

        if (!Strings.isNullOrEmpty(userData.getPrimaryEmail()) && Strings.isNullOrEmpty(userData.getSecondaryEmail())) {
            // primary is set, secondary empty
            userData.setSecondaryEmail(userData.getPrimaryEmail());
        }
        if (!Strings.isNullOrEmpty(userData.getSecondaryEmail()) && Strings.isNullOrEmpty(userData.getPrimaryEmail())) {
            // secondary is set, primary empty
            userData.setPrimaryEmail(userData.getSecondaryEmail());
        }

        if (Strings.isNullOrEmpty(userData.getPrimaryEmail()) && Strings.isNullOrEmpty(userData.getSecondaryEmail())) {
            userData.setPrimaryEmail(defaultEmail);
            userData.setSecondaryEmail(defaultEmail);
        }

        List<UserAddress> addresses = userData.getAddresses();

        userData.setAddresses(setMissingFieldsInAddress(addresses));
        producerEngine.sendUserContactEvent(userContactEvent);
    }

    @Async
    public void sendManyUserContactEvents(List<UserData> userContactList, String eventType, String source) {
        for (UserData userContact : userContactList) {
            this.sendUserContactEvent(userContact, eventType, source);
        }
    }

    @Async
    public void sendStudentRecordEvent(AcademicLifeStudentRecord studentRecord, String eventType, String source) {
        StudentRecordEvent studentRecordEvent = new StudentRecordEvent(studentRecord, eventType, source);

        AcademicLifeStudent student = studentRecord.getStudent();
        if (!Strings.isNullOrEmpty(student.getPrimaryEmail()) && Strings.isNullOrEmpty(student.getSecondaryEmail())) {
            // primary is set, secondary empty
            student.setSecondaryEmail(student.getPrimaryEmail());
        }
        if (!Strings.isNullOrEmpty(student.getSecondaryEmail()) && Strings.isNullOrEmpty(student.getPrimaryEmail())) {
            // secondary is set, primary empty
            student.setPrimaryEmail(student.getSecondaryEmail());
        }

        if (Strings.isNullOrEmpty(student.getPrimaryEmail()) && Strings.isNullOrEmpty(student.getSecondaryEmail())) {
            student.setPrimaryEmail(defaultEmail);
            student.setSecondaryEmail(defaultEmail);
        }

        List<UserAddress> addresses = student.getAddresses();

        student.setAddresses(setMissingFieldsInAddress(addresses));

        if (studentRecord.getStatus().getId() == 16L) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = studentRecord.getStatus().getDate().format(formatter);
            studentRecord.setGraduateDate(formattedDateTime);

        }

        producerEngine.sendStudentRecordEvent(studentRecordEvent);
    }

    @Async
    public void sendManyStudentRecordEvents(List<AcademicLifeStudentRecord> studentRecordList, String eventType,
                                            String source) {
        for (AcademicLifeStudentRecord studentRecord : studentRecordList) {
            this.sendStudentRecordEvent(studentRecord, eventType, source);
        }
    }

    private void processEnrollmentEvent(Enrollment enrollmentEvent) {
        if (enrollmentEvent.getTickets() != null) {

            for (var ticket : enrollmentEvent.getTickets()) {
                ticket.setValorBruto(0.0);
                ticket.setPriceId(0L);
            }
        }
        StudentRecord studentRecord = enrollmentEvent.getStudentRecord();
        Student student = studentRecord.getStudent();
        if (!Strings.isNullOrEmpty(student.getPrimaryEmail()) && Strings.isNullOrEmpty(student.getSecondaryEmail())) {
            // primary is set, secondary empty
            student.setSecondaryEmail(student.getPrimaryEmail());
        }
        if (!Strings.isNullOrEmpty(student.getSecondaryEmail()) && Strings.isNullOrEmpty(student.getPrimaryEmail())) {
            // secondary is set, primary empty
            student.setPrimaryEmail(student.getSecondaryEmail());
        }

        if (Strings.isNullOrEmpty(student.getPrimaryEmail()) && Strings.isNullOrEmpty(student.getSecondaryEmail())) {
            student.setPrimaryEmail(defaultEmail);
            student.setSecondaryEmail(defaultEmail);
        }

        Contact contact = student.getContact();

        if (!Strings.isNullOrEmpty(contact.getPrimaryEmail()) && Strings.isNullOrEmpty(contact.getSecondaryEmail())) {
            // primary is set, secondary empty
            contact.setSecondaryEmail(contact.getPrimaryEmail());
        }
        if (!Strings.isNullOrEmpty(contact.getSecondaryEmail()) && Strings.isNullOrEmpty(contact.getPrimaryEmail())) {
            // secondary is set, primary empty
            contact.setPrimaryEmail(contact.getSecondaryEmail());
        }

        if (Strings.isNullOrEmpty(contact.getPrimaryEmail()) && Strings.isNullOrEmpty(contact.getSecondaryEmail())) {
            contact.setPrimaryEmail(defaultEmail);
            contact.setSecondaryEmail(defaultEmail);
        }

        if (enrollmentEvent.isMassive()) {
            contact.setCrmSource(ORIGIN_MASSIVE);
            studentRecord.setStatus(5l); // hardcoded for crm;

        } else if (contact.getCrmSource() == null || contact.getCrmSource().length() == 0) {
            contact.setCrmSource(ORIGIN_ECOMERCE);
        }

        contact.getAddresses().stream().filter(a -> a.getLocationRef() == null && a.getLocationId() != null).parallel()
                .forEach(address -> {
                    try {

                        var rep = admissionClient.getLocation(address.getLocationId()).execute();
                        if (rep.isSuccessful()) {
                            Location locationRef = rep.body();
                            address.setLocationRef(locationRef);
                        }
                    } catch (Exception e) {
                        LOGGER.error("Contact Address Location INVALID : " + studentRecord.getId());
                    }

                });
    }

    private List<UserAddress> setMissingFieldsInAddress(List<UserAddress> addresses) {
        Country country = new Country();
        country.setId(51L);
        country.setName("SIN DATOS");
        country.setNationality("SIN DATOS");

        Province province = new Province();
        province.setCountry(country);
        province.setId(4614L);
        province.setName("SIN DATOS");

        Location location = new Location();
        location.setProvince(province);
        location.setId(4798L);
        location.setName("SIN DATOS");


        if (Objects.nonNull(addresses)) {
            for (UserAddress address : addresses) {
                if (address.getLocation() == null) {
                    address.setLocation(location);
                }

                if (!Strings.isNullOrEmpty(address.getTelephoneNumber1()) && Strings.isNullOrEmpty(address.getTelephoneNumber2())) {
                    // primary is set, secondary empty
                    address.setTelephoneNumber2(address.getTelephoneNumber1());
                }
                if (!Strings.isNullOrEmpty(address.getTelephoneNumber2()) && Strings.isNullOrEmpty(address.getTelephoneNumber1())) {
                    // secondary is set, primary empty
                    address.setTelephoneNumber1(address.getTelephoneNumber2());
                }

                if (Strings.isNullOrEmpty(address.getTelephoneNumber1()) && Strings.isNullOrEmpty(address.getTelephoneNumber2())) {
                    address.setTelephoneNumber1("N/A");
                    address.setTelephoneNumber2("N/A");
                }

            }
            return addresses;

        } else {
            UserAddress address = new UserAddress();
            address.setId(1L);
            address.setLocation(location);
            address.setApartment("SIN DATOS");
            address.setDetails("SIN DATOS");
            address.setFax("SIN DATOS");
            address.setFloor("SIN DATOS");
            address.setLocation(location);
            address.setNeighborhood("SIN DATOS");
            address.setNeighborhoodId(2746L);
            address.setNumber("SIN DATOS");
            address.setPostalCode("SIN DATOS");
            address.setTelephoneNumber1("N/A");
            address.setTelephoneNumber2("N/A");
            address.setStreet("SIN DATOS");
            address.setStreetId(12148L);
            address.setTower("SIN DATOS");
            address.setType(1);

            return Collections.singletonList(address);
        }
    }
}
