package ar.edu.ues21.algarrobo.admissioneventservice.model.User;



import java.util.List;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Student.Gender;
import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.ContactAvailability;
import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Country;
import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.CreationSource;
import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.DocumentType;
import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.MaritalStatus;
import ar.edu.ues21.algarrobo.admissioneventservice.model.User.Origin.UserOrigin;

public class UserData {

    private List<UserAddress> addresses;

    private String age;
    private Long attendanceModeID;
    private float average;
    private UserBirthPlace birthPlace;
    private String birthdate;
    private Integer categoriaInforme;
    private ContactAvailability contactAvailability;
    private List<UserContactRequest> contactRequests;
    private Country country;
    private String creationDate;
    private CreationSource creationSource;
    private String documentNumber;
    private DocumentType documentType;
    private String firstContactName;
    private Gender gender;
    private String graduationDate;
    private String id;
    private Integer informadoStatus;
    private InstitutionId institutionId;
    private String lastName;
    private MaritalStatus maritalStatus;
    private String name;
    private UserNationality nationality;
    private List<UserOrigin> origin;
    private String primaryEmail;
    private String relatives;
    private String requestedInformation;
    private String secondaryEmail;
    private Integer siteId;
    private String status;
    private String statusDate;
    private String studyClass;
    private TitleId titleId;
    private String usrPortal;
    private Integer workingHours;
    private String economicSituation;
    private String workingStatus;
    private String workingCompany;

    public List<UserAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<UserAddress> addresses) {
        this.addresses = addresses;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Long getAttendanceModeID() {
        return attendanceModeID;
    }

    public void setAttendanceModeID(Long attendanceModeID) {
        this.attendanceModeID = attendanceModeID;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public UserBirthPlace getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(UserBirthPlace birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getCategoriaInforme() {
        return categoriaInforme;
    }

    public void setCategoriaInforme(Integer categoriaInforme) {
        this.categoriaInforme = categoriaInforme;
    }

    public ContactAvailability getContactAvailability() {
        return contactAvailability;
    }

    public void setContactAvailability(ContactAvailability contactAvailability) {
        this.contactAvailability = contactAvailability;
    }

    public List<UserContactRequest> getContactRequests() {
        return contactRequests;
    }

    public void setContactRequests(List<UserContactRequest> contactRequests) {
        this.contactRequests = contactRequests;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public CreationSource getCreationSource() {
        return creationSource;
    }

    public void setCreationSource(CreationSource creationSource) {
        this.creationSource = creationSource;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getFirstContactName() {
        return firstContactName;
    }

    public void setFirstContactName(String firstContactName) {
        this.firstContactName = firstContactName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getInformadoStatus() {
        return informadoStatus;
    }

    public void setInformadoStatus(Integer informadoStatus) {
        this.informadoStatus = informadoStatus;
    }

    public InstitutionId getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(InstitutionId institutionId) {
        this.institutionId = institutionId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserNationality getNationality() {
        return nationality;
    }

    public void setNationality(UserNationality nationality) {
        this.nationality = nationality;
    }

    public List<UserOrigin> getOrigin() {
        return origin;
    }

    public void setOrigin(List<UserOrigin> origin) {
        this.origin = origin;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getRelatives() {
        return relatives;
    }

    public void setRelatives(String relatives) {
        this.relatives = relatives;
    }

    public String getRequestedInformation() {
        return requestedInformation;
    }

    public void setRequestedInformation(String requestedInformation) {
        this.requestedInformation = requestedInformation;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getStudyClass() {
        return studyClass;
    }

    public void setStudyClass(String studyClass) {
        this.studyClass = studyClass;
    }

    public TitleId getTitleId() {
        return titleId;
    }

    public void setTitleId(TitleId titleId) {
        this.titleId = titleId;
    }

    public String getUsrPortal() {
        return usrPortal;
    }

    public void setUsrPortal(String usrPortal) {
        this.usrPortal = usrPortal;
    }

    public Integer getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Integer workingHours) {
        this.workingHours = workingHours;
    }

    public String getEconomicSituation() {
        return economicSituation;
    }

    public void setEconomicSituation(String economicSituation) {
        this.economicSituation = economicSituation;
    }

    public String getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }

    public String getWorkingCompany() {
        return workingCompany;
    }

    public void setWorkingCompany(String workingCompany) {
        this.workingCompany = workingCompany;
    }
}
