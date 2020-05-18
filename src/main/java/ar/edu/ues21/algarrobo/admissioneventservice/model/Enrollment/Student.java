package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("Students")
@Entity
@Table(name = "UE_ALUMNOS", schema = "UE21")
@Data
@JsonIgnoreProperties({"studentRecords"})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UE_ALUMNOS_SEQ")
    @SequenceGenerator(name = "UE_ALUMNOS_SEQ", sequenceName = "UE_ALUMNOS_SEQ", allocationSize = 1)
    private Long id;

    @ApiModelProperty(value = "student's name", example = "DANIELA VERONICA")
    @Column(name = "NOMBRES")
    private String name;

    @ApiModelProperty(value = "student's lastname", example = "CRDWFQXNEY")
    @Column(name = "APELLIDO")
    private String lastName;

    @ApiModelProperty(value = "student's gender")
    @ManyToOne
    @JoinColumn(name = "SEXO")
    private Gender gender;

    @ApiModelProperty(value = "student's birthdate", example = "1987-07-28")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FECHA_NAC")
    private LocalDate birthDate;

    @ApiModelProperty(value = "student's marital status")
    @ManyToOne
    @JoinColumn(name = "ESTADO_CIVIL")
    private MaritalStatus maritalStatus;

    @ApiModelProperty(value = "student's economic situation", example = "1")
    @Column(name = "SIT_ECONOMICA")
    private Long economicSituation;

    // Don't used attribute
    /*@ApiModelProperty(value = "student's financing", example = "1")
    @Column(name = "FFINANCIACION")
    private Long financing;*/

    @ApiModelProperty(value = "student's status date", example = "2019-03-20T15:14:12Z")
    @Column(name = "FECHA_ESTADO")
    private LocalDateTime statusDate;

    @ApiModelProperty(value = "student's document type")
    @ManyToOne
    @JoinColumn(name = "TIPO_DOC")
    private DocumentType documentType;

    @ApiModelProperty(value = "student's document number", example = "77779350")
    @Column(name = "NRO_DOC")
    private Long documentNumber;

    @ApiModelProperty(value = "student's primary email", example = "VQWNDADSZD@gmail.com")
    @Column(name = "E_MAIL_PRIMARIO")
    private String primaryEmail;

    @ApiModelProperty(value = "student's secondary email", example = "WWQQUFBXZP@gmail.com")
    @Column(name = "E_MAIL_SECUNDARIO")
    private String secondaryEmail;

    @ApiModelProperty(value = "student's birth place")
    @ManyToOne
    @JoinColumn(name = "LOC_ID_NAC")
    private Location birthPlace;

    @ApiModelProperty(value = "student's status", example = "2")
    @Column(name = "ESTADO_ALUMNO")
    private Long status;

    @ApiModelProperty(value = "student's username", example = "ARGENTINA")
    @Column(name = "USR_PORTAL")
    private String usrPortal;

    @ApiModelProperty(value = "student's contact", example = "1032524")
    @ManyToOne
    @JoinColumn(name = "INFORMADO_ID")
    private Contact contact;

    @ApiModelProperty(value = "student's load date", example = "2003-03-20T03:00:00Z")
    @Column(name = "FECHA_CARGA")
    private LocalDateTime loadDate;

    @ApiModelProperty(value = "student's username", example = "1")
    @Column(name = "KIT_ENVIADO")
    private Long sentKit;

    @ApiModelProperty(value = "student's username", example = "2")
    @Column(name = "KIT_RECIBIDO")
    private Long receivedKit;

    @ApiModelProperty(value = "student's generated card", example = "1")
    @Column(name = "TARJETA_GENERADA")
    private Long generatedCard;

    @ApiModelProperty(value = "student's type", example = "2")
    @Column(name = "TIPO_ALUMNO")
    private Long studentType;

    @ApiModelProperty(value = "student's benefit kind", example = "0")
    @Column(name = "TIPO_BENEFICIO")
    private Long benefitKind;

    @ApiModelProperty(value = "the user that start the enrollment process", example = "2")
    @Column(name = "USR_PORTAL_INSCR")
    private String enrollmentUser;

    /*@ApiModelProperty(value = "delivered", example = "0")
    @Column(name = "ENTREGADO")
    private Integer delivered;*/

    @ApiModelProperty(value = "student's nationality", example = "ARGENTINA")
    @ManyToOne
    @JoinColumn(name = "NACIONALIDAD_ID")
    private Country nationality;

    @ApiModelProperty(value = "student's country", example = "ARGENTINA")
    @ManyToOne
    @JoinColumn(name = "PA_ID")
    private Country country;

    /*@ApiModelProperty(value = "student's file status", example = "P")
    @Column(name = "ESTADO_FICHA")
    private String fileStatus;*/

    /*@ApiModelProperty(value = "student's file status", example = "P")
    @Column(name = "RIESGO")
    private Long risk;*/

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "UE_ALUMNO_DOMICILIOS",
        joinColumns = @JoinColumn(name = "ALU_ID"),
        inverseJoinColumns = @JoinColumn(name = "DOM_ID")
    )
    private Set<ContactAddress> addresses;

    @ApiModelProperty(value = "StudentRecords")
    @OneToMany(mappedBy = "student")
    private Set<StudentRecord> studentRecords;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public MaritalStatus getMaritalStatus() {
        return this.maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Long getEconomicSituation() {
        return this.economicSituation;
    }

    public void setEconomicSituation(Long economicSituation) {
        this.economicSituation = economicSituation;
    }

    /*public Long getFinancing() {
        return this.financing;
    }

    public void setFinancing(Long financing) {
        this.financing = financing;
    }*/

    public LocalDateTime getStatusDate() {
        return this.statusDate;
    }

    public void setStatusDate(LocalDateTime statusDate) {
        this.statusDate = statusDate;
    }

    public DocumentType getDocumentType() {
        return this.documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Long getDocumentNumber() {
        return this.documentNumber;
    }

    public void setDocumentNumber(Long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getPrimaryEmail() {
        return this.primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getSecondaryEmail() {
        return this.secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public Location getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(final Location birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Long getStatus() {
        return this.status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getUsrPortal() {
        return this.usrPortal;
    }

    public void setUsrPortal(String usrPortal) {
        this.usrPortal = usrPortal;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public LocalDateTime getLoadDate() {
        return this.loadDate;
    }

    public void setLoadDate(LocalDateTime loadDate) {
        this.loadDate = loadDate;
    }

    public Long getSentKit() {
        return this.sentKit;
    }

    public void setSentKit(Long sentKit) {
        this.sentKit = sentKit;
    }

    public Long getReceivedKit() {
        return this.receivedKit;
    }

    public void setReceivedKit(Long receivedKit) {
        this.receivedKit = receivedKit;
    }

    public Long getGeneratedCard() {
        return this.generatedCard;
    }

    public void setGeneratedCard(Long generatedCard) {
        this.generatedCard = generatedCard;
    }

    public Long getStudentType() {
        return this.studentType;
    }

    public void setStudentType(Long studentType) {
        this.studentType = studentType;
    }

    public Long getBenefitKind() {
        return this.benefitKind;
    }

    public void setBenefitKind(Long benefitKind) {
        this.benefitKind = benefitKind;
    }

    public String getEnrollmentUser() {
        return enrollmentUser;
    }

    public void setEnrollmentUser(final String enrollmentUser) {
        this.enrollmentUser = enrollmentUser;
    }

    /*public Integer getDelivered() {
        return delivered;
    }

    public void setDelivered(Integer delivered) {
        this.delivered = delivered;
    }*/

    public Country getNationality() {
        return this.nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    /*public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }*/

    /*public Long getRisk() {
        return risk;
    }

    public void setRisk(Long risk) {
        this.risk = risk;
    }*/

    public Set<StudentRecord> getStudentRecords() {
        return studentRecords;
    }

    public void setStudentRecords(final Set<StudentRecord> studentRecords) {
        this.studentRecords = studentRecords;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", maritalStatus=" + maritalStatus +
                ", economicSituation=" + economicSituation +
                ", statusDate=" + statusDate +
                ", documentType=" + documentType +
                ", documentNumber=" + documentNumber +
                ", primaryEmail='" + primaryEmail + '\'' +
                ", secondaryEmail='" + secondaryEmail + '\'' +
                ", birthPlace=" + birthPlace +
                ", status=" + status +
                ", usrPortal='" + usrPortal + '\'' +
                ", contact=" + contact +
                ", loadDate=" + loadDate +
                ", sentKit=" + sentKit +
                ", receivedKit=" + receivedKit +
                ", generatedCard=" + generatedCard +
                ", studentType=" + studentType +
                ", benefitKind=" + benefitKind +
                ", enrollmentUser='" + enrollmentUser + '\'' +
                ", nationality=" + nationality +
                ", country=" + country +
                ", addresses=" + addresses +
                '}';
    }
}