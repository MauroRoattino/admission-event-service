package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("Students")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"studentRecords"})
public class Student {

    @ApiModelProperty(example = "11841")
    private Long id;

    @ApiModelProperty(value = "student's name", example = "CRISTIAN JULIO")
    private String name;

    @ApiModelProperty(value = "student's lastname", example = "EIMFVQFAIJ")
    private String lastName;

    @ApiModelProperty(value = "student's gender")
    private Gender gender;

    @ApiModelProperty(value = "student's birthdate", example = "1971-09-18")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @ApiModelProperty(value = "student's marital status")
    private MaritalStatus maritalStatus;

    @ApiModelProperty(value = "student's economic situation", example = "1")
    private Long economicSituation;

    @ApiModelProperty(value = "student's status date", example = "2016-07-09T17:05:00")
    private LocalDateTime statusDate;

    @ApiModelProperty(value = "student's document type")
    private DocumentType documentType;

    @ApiModelProperty(value = "student's document number", example = "34107754")
    private Long documentNumber;

    @ApiModelProperty(value = "student's primary email", example = "QVLIGWUFLP@gmail.com")
    private String primaryEmail;

    @ApiModelProperty(value = "student's secondary email", example = "LRLXJMIVST@gmail.com")
    private String secondaryEmail;

    @ApiModelProperty(value = "student's birth place")
    private Location birthPlace;

    @ApiModelProperty(value = "student's status", example = "1")
    private Long status;

    @ApiModelProperty(value = "student's username", example = "CRSANCHEZ")
    private String usrPortal;

    @ApiModelProperty(value = "student's contact")
    private Contact contact;

    @ApiModelProperty(value = "student's load date", example = "2003-03-20T03:00:00Z")
    private LocalDateTime loadDate;

    @ApiModelProperty(value = "student's username", example = "1")
    private Long sentKit;

    @ApiModelProperty(value = "student's username", example = "2")
    private Long receivedKit;

    @ApiModelProperty(value = "student's generated card", example = "1")
    private Long generatedCard;

    @ApiModelProperty(value = "student's type", example = "2")
    private Long studentType;

    @ApiModelProperty(value = "student's benefit kind", example = "0")
    private Long benefitKind;

    @ApiModelProperty(value = "the user that start the enrollment process", example = "GABUIN")
    private String enrollmentUser;

    @ApiModelProperty(value = "student's nationality")
    private Country nationality;

    @ApiModelProperty(value = "student's country")
    private Country country;

    private Set<ContactAddress> addresses;

    @ApiModelProperty(value = "StudentRecords")
    private Set<StudentRecord> studentRecords;
}