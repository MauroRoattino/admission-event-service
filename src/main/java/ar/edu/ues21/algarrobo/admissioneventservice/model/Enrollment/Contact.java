package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("Contact")
@JsonInclude(Include.NON_NULL)
public class Contact {

    @ApiModelProperty(value = "The informado's name", example = "1032026")
    private Long id;

    @ApiModelProperty(value = "The informado's name", example = "CRISTIAN JULIO")
    private String name;

    @ApiModelProperty(value = "The informado's last name", example = "EIMFVQFAIJ")
    private String lastName;

    @ApiModelProperty(value = "The informado's gender")
    private Gender gender;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "The informado's bithdate", example = "1977-05-16")
    private LocalDate birthdate;

    @ApiModelProperty(value = "The informado's gender")
    private MaritalStatus maritalStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "The informado's status date", example = "2011-08-05")
    private LocalDate statusDate;

    @ApiModelProperty(value = "The informado's document type")
    private DocumentType documentType;

    @ApiModelProperty(value = "The informado's document number", example = "34107754")
    private Long documentNumber;

    @ApiModelProperty(value = "The informado's primary email", example = "QVLIGWUFLP@gmail.com")
    private String primaryEmail;

    @ApiModelProperty(value = "The informado's secondary email", example = "LRLXJMIVST@gmail.com")
    private String secondaryEmail;

    @ApiModelProperty(value = "The informado's birth place")
    private Location birthPlace;

    @ApiModelProperty(value = "The user name that created the informado", example = "CRSANCHEZ")
    private String usrPortal;

    @ApiModelProperty(value = "The study class", example = "4")
    private String studyClass;

    @ApiModelProperty(value = "The amount of relatives that the user has in charge", example = "2")
    private Long relatives;

    @ApiModelProperty(value = "Requested information", example = "GENERAL")
    private String requestedInformation;

    @ApiModelProperty(value = "The informado's age", example = "40")
    private String age;

    @ApiModelProperty(value = "The creation date", example = "2008-01-30")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    @ApiModelProperty(value = "The informado's status", example = "1")
    private String informadoStatus;

    @ApiModelProperty(value = "The informado's source")
    private CreationSource creationSource;

    @ApiModelProperty(value = "The informado's availability hours for communication")
    private ContactAvailability contactAvailability;

    @ApiModelProperty(value = "The status", example = "1")
    private Long status;

    @ApiModelProperty(value = "The informado's attendance mode", example = "1")
    private Long attendanceModeID;

    @ApiModelProperty(value =  "backwards compatible attendance mode param. DEPRECATED, please use attendance mode id")
    private AttendanceMode attendanceMode;

    @ApiModelProperty(value = "The site id", example = "1")
    private Long siteId;

    @ApiModelProperty(value = "First contact name", example = "AMENGHI")
    private String firstContactName;

    @ApiModelProperty(value = "The status category", example = "1")
    private Long categoriaInforme;

    @ApiModelProperty(value = "The informado's country")
    private Country country;

    @ApiModelProperty(value = "The informado's nationality")
    private Country nationality;

    private Set<ContactAddress> addresses;

    private List<ContactOrigin> origin;

    private List<ContactRequests> contactRequests;
    
    @ApiModelProperty(value = "The institution id", example = "1")
    private Institution institutionId;
    
    @ApiModelProperty(value = "The institution title id", example = "1")
    private InstitutionTitle titleId;

    @ApiModelProperty(value = "The site id", example = "2010-10-20")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate graduationDate;
    
    @ApiModelProperty(value = "The site id", example = "7.5")
    private Double average;
}

