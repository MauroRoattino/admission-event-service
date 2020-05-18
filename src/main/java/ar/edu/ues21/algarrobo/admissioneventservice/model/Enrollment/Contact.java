package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@ApiModel("Contact")
@Entity
@Table(name = "UE_INFORMADOS", schema = "UE21")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"contactRequests"})
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UE_INFORMADOS_SEQ")
    @SequenceGenerator(name = "UE_INFORMADOS_SEQ", sequenceName = "UE_INFORMADOS_SEQ", allocationSize = 1)
    private Long id;

    @ApiModelProperty(value = "The informado's name", example = "Nombre")
    @Column(name = "NOMBRES")
    private String name;

    @ApiModelProperty(value = "The informado's last name", example = "Apellido")
    @Column(name = "APELLIDO")
    private String lastName;

    @ApiModelProperty(value = "The informado's gender")
    @ManyToOne
    @JoinColumn(name = "SEXO")
    private Gender gender;

    @ApiModelProperty(value = "The informado's bithdate", example = "1987-07-28")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FECHA_NAC")
    private LocalDate birthdate;

    @ApiModelProperty(value = "The informado's gender")
    @ManyToOne
    @JoinColumn(name = "ESTADO_CIVIL")
    private MaritalStatus maritalStatus;

    @ApiModelProperty(value = "The informado's status date", example = "2018-02-20")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FECHA_ESTADO")
    private LocalDate statusDate;

    @ApiModelProperty(value = "The informado's document type")
    @ManyToOne
    @JoinColumn(name = "TIPO_DOC")
    private DocumentType documentType;

    @ApiModelProperty(value = "The informado's document number", example = "2018-02-20")
    @Column(name = "NRO_DOC")
    private Long documentNumber;

    @ApiModelProperty(value = "The informado's primary email", example = "DQGMJRWZBF@gmail.com")
    @Column(name = "E_MAIL_PRIMARIO")
    private String primaryEmail;

    @ApiModelProperty(value = "The informado's secondary email", example = "DQGMJRWZBF@gmail.com")
    @Column(name = "E_MAIL_SECUNDARIO")
    private String secondaryEmail;

    @ApiModelProperty(value = "The informado's birth place")
    @ManyToOne
    @JoinColumn(name = "LOC_ID_NAC")
    private Location birthPlace;

    @ApiModelProperty(value = "The user name that created the informado", example = "SUPERUSUARIO")
    @Column(name = "USR_PORTAL")
    private String usrPortal;

    @ApiModelProperty(value = "The study class", example = "1")
    @Column(name = "TIPO_CARRERA")
    private String studyClass;

    @ApiModelProperty(value = "The amount of relatives that the user has in charge", example = "NAPELLIDO")
    @Column(name = "FAMILIARES_A_CARGO")
    private Long relatives;

    @ApiModelProperty(value = "Requested information", example = "GENERAL")
    @Column(name = "INFORMACION_SOBRE")
    private String requestedInformation;

    @ApiModelProperty(value = "The informado's age", example = "20")
    @Column(name = "EDAD")
    private String age;

    @ApiModelProperty(value = "The creation date", example = "20")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FECHA_CARGA")
    private LocalDate creationDate;

    @ApiModelProperty(value = "The informado's status", example = "1")
    @Column(name = "ESTADO_INFORMADO")
    private String informadoStatus;

    @ApiModelProperty(value = "The informado's source")
    @ManyToOne
    @JoinColumn(name = "ORIGEN_CARGA")
    private CreationSource creationSource;

    @ApiModelProperty(value = "The informado's availability hours for communication")
    @ManyToOne
    @JoinColumn(name = "HORARIO_CONTACTO")
    private ContactAvailability contactAvailability;

    @ApiModelProperty(value = "The status", example = "1")
    @Column(name = "ESTADO")
    private Long status;

    @ApiModelProperty(value = "The informado's attendance mode")
    @Column(name = "TIPO_ESTUDIO")
    private Long attendanceModeID;


    @ApiModelProperty(value =  "backwards compatible attendance mode param. DEPRECATED, please use attendance mode id")
    @Transient
    private AttendanceMode attendanceMode;

    @ApiModelProperty(value = "The site id", example = "1")
    @Column(name = "SITE_ID")
    private Long siteId;

    @ApiModelProperty(value = "First contact name", example = "1")
    @Column(name = "PRIMER_CONTACTO")
    private String firstContactName;

    @ApiModelProperty(value = "The status category", example = "1")
    @Column(name = "ESTADO_CATEGORIA_INF")
    private Long categoriaInforme;

    @ApiModelProperty(value = "The informado's country")
    @ManyToOne
    @JoinColumn(name = "PA_ID")
    private Country country;

    @ApiModelProperty(value = "The informado's nationality")
    @ManyToOne
    @JoinColumn(name = "NACIONALIDAD_ID")
    private Country nationality;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name = "UE_INFORMADOS_DOMICILIOS",
        joinColumns = @JoinColumn(name = "INF_ID"),
        inverseJoinColumns = @JoinColumn(name = "DOM_ID")
    )
    private Set<ContactAddress> addresses;

    @OneToMany(mappedBy = "id.contact")
    private List<ContactOrigin> origin;

    @OneToMany(mappedBy = "id.contact")
    private List<ContactRequests> contactRequests;
    
    @ApiModelProperty(value = "The institution id", example = "1")
    @ManyToOne(optional = true)
    @JoinColumn(name = "INSTITUCION_ID")
    private Institution institutionId;
    
    @ApiModelProperty(value = "The institution title id", example = "1")
    @ManyToOne(optional = true)
    @JoinColumn(name = "TITULO_ID")
    private InstitutionTitle titleId;

    @ApiModelProperty(value = "The site id", example = "2010-10-20")
    @Column(name = "FECHA_EGRESO")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate graduationDate;
    
    @ApiModelProperty(value = "The site id", example = "7.5")
    @Column(name = "PROMEDIO")
    private Double average;
    
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(final Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(final LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(final MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public LocalDate getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(final LocalDate statusDate) {
        this.statusDate = statusDate;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(final DocumentType documentType) {
        this.documentType = documentType;
    }

    public Long getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(final Long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(final String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(final String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public Location getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(final Location birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getUsrPortal() {
        return usrPortal;
    }

    public void setUsrPortal(final String usrPortal) {
        this.usrPortal = usrPortal;
    }

    public String getStudyClass() {
        return studyClass;
    }

    public void setStudyClass(final String studyClass) {
        this.studyClass = studyClass;
    }

    public Long getRelatives() {
        return relatives;
    }

    public void setRelatives(final Long relatives) {
        this.relatives = relatives;
    }

    public String getRequestedInformation() {
        return requestedInformation;
    }

    public void setRequestedInformation(final String requestedInformation) {
        this.requestedInformation = requestedInformation;
    }

    public String getAge() {
        return age;
    }

    public void setAge(final String age) {
        this.age = age;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(final LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getInformadoStatus() {
        return informadoStatus;
    }

    public void setInformadoStatus(final String informadoStatus) {
        this.informadoStatus = informadoStatus;
    }

    public CreationSource getCreationSource() {
        return creationSource;
    }

    public void setCreationSource(final CreationSource creationSource) {
        this.creationSource = creationSource;
    }

    public ContactAvailability getContactAvailability() {
        return contactAvailability;
    }

    public void setContactAvailability(final ContactAvailability contactAvailability) {
        this.contactAvailability = contactAvailability;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(final Long status) {
        this.status = status;
    }

    public Long getAttendanceModeID() {
        return attendanceModeID;
    }

    public void setAttendanceModeID(final Long attendanceMode) {
        this.attendanceModeID = attendanceMode;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(final Long siteId) {
        this.siteId = siteId;
    }

    public String getFirstContactName() {
        return firstContactName;
    }

    public void setFirstContactName(final String firstContactName) {
        this.firstContactName = firstContactName;
    }

    public Long getCategoriaInforme() {
        return categoriaInforme;
    }

    public void setCategoriaInforme(final Long categoriaInforme) {
        this.categoriaInforme = categoriaInforme;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(final Country country) {
        this.country = country;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(final Country nationality) {
        this.nationality = nationality;
    }

    public Set<ContactAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(final Set<ContactAddress> addresses) {
        this.addresses = addresses;
    }

    public List<ContactOrigin> getOrigin() {
        return origin;
    }

    public void setOrigin(final List<ContactOrigin> origin) {
        this.origin = origin;
    }

    public List<ContactRequests> getContactRequests() {
        return contactRequests;
    }

    public void setContactRequests(final List<ContactRequests> contactRequests) {
        this.contactRequests = contactRequests;
    }

    @Override
    public String toString() {
        return "Contact:{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", gender='" + getGender() + "'" +
            ", birthdate='" + getBirthdate() + "'" +
            ", maritalStatus='" + getMaritalStatus() + "'" +
            ", statusDate='" + getStatusDate() + "'" +
            ", documentType='" + getDocumentType() + "'" +
            ", documentNumber='" + getDocumentNumber() + "'" +
            ", primaryEmail='" + getPrimaryEmail() + "'" +
            ", secondaryEmail='" + getSecondaryEmail() + "'" +
            ", usrPortal='" + getUsrPortal() + "'" +
            ", studyClass='" + getStudyClass() + "'" +
            ", relatives='" + getRelatives() + "'" +
            ", requestedInformation='" + getRequestedInformation() + "'" +
            ", age='" + getAge() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            ", informadoStatus='" + getInformadoStatus() + "'" +
            ", creationSource='" + getCreationSource() + "'" +
            ", contactAvailability='" + getContactAvailability() + "'" +
            ", status='" + getStatus() + "'" +
            ", attendanceMode='" + getAttendanceModeID() + "'" +
            ", siteId='" + getSiteId() + "'" +
            ", firstContactName='" + getFirstContactName() + "'" +
            ", categoriaInforme='" + getCategoriaInforme() + "'" +
            ", country='" + getCountry() + "'" +
            ", nationality='" + getNationality() + "'" +
            ", addresses='" + getAddresses() + "'" +
            ", origin='" + getOrigin() + "'" +
            ", contactRequests='" + getContactRequests() + "'" +
            "}";
    }

    public void setAttendanceMode(AttendanceMode attendanceMode) {
        this.attendanceMode = attendanceMode;
        if (attendanceMode != null) {
            this.attendanceModeID = attendanceMode.getId();
        } else {
            this.attendanceModeID = null;
        }
    }

	public Institution getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(Institution institutionId) {
		this.institutionId = institutionId;
	}

	public InstitutionTitle getTitleId() {
		return titleId;
	}

	public void setTitleId(InstitutionTitle titleId) {
		this.titleId = titleId;
	}

	public LocalDate getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(LocalDate graduationDate) {
		this.graduationDate = graduationDate;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}
}

