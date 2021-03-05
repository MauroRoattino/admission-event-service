package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Student;

import ar.edu.ues21.algarrobo.admissioneventservice.model.User.UserAddress;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class AcademicLifeStudent {

    @ApiModelProperty(name = "id", example = "135239")
    private String id;

    @ApiModelProperty(name = "name", example = "PENELOPE")
    private String name;

    @ApiModelProperty(name = "lastName", example = "CRUZ")
    private String lastName;

    private Gender gender;

    @ApiModelProperty(name = "addresses",
            value = "This field is populated from the " +
            "[User API](https://api.ues21.edu.ar/user/api/swagger-ui.html#/Users/findStudentUsingGET). If the User API " +
            "returned addresses for this student, then these will be used. Otherwise, it will be populated with one default address " +
            "that corresponds to _NO DATA_")
    private List<UserAddress> addresses;

    @ApiModelProperty(name = "birthDate", example = "1987-10-30")
    private String birthDate;

    @ApiModelProperty(name = "statusDate", example = "2013-07-27T00:00:00")
    private String statusDate;

    @ApiModelProperty(name = "documentType", example = "1")
    private String documentType;

    @ApiModelProperty(name = "documentNumber", example = "36541463")
    private Long documentNumber;

    @ApiModelProperty(name = "primaryEmail", example = "penelope.cruz@gmail.com",
            value = "If this email is empty, it will be populated with the _secondary email_ or a default email (notengomail@ues21.edu.ar)")
    private String primaryEmail;

    @ApiModelProperty(name = "secondaryEmail", example = "penelope.cruz2@gmail.com",
            value = "If this email is empty, it will be populated with the _primary email_ or a default email (notengomail@ues21.edu.ar)")
    private String secondaryEmail;

    @ApiModelProperty(name = "status", example = "1")
    private Long status;

    @ApiModelProperty(name = "usrPortal", example = "PPEREDABERNARDI")
    private String usrPortal;

    @ApiModelProperty(name = "personType", example = "Estudiante",
            value = "This value is hardcoded in ngg-batch-jobs batch processing. It will always be _Estudiante_")
    private String personType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<UserAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<UserAddress> addresses) {
        this.addresses = addresses;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Long getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getUsrPortal() {
        return usrPortal;
    }

    public void setUsrPortal(String usrPortal) {
        this.usrPortal = usrPortal;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

}
