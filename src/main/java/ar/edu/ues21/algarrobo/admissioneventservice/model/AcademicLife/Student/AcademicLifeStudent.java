package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Student;

import io.swagger.annotations.ApiModelProperty;

public class AcademicLifeStudent {

    @ApiModelProperty(name = "id", example = "135239")
    private Long id;

    @ApiModelProperty(name = "name", example = "PENELOPE")
    private String name;

    @ApiModelProperty(name = "lastName", example = "CRUZ")
    private String lastName;

    private Gender gender;

    @ApiModelProperty(name = "birthDate", example = "1987-10-30")
    private String birthDate;

    @ApiModelProperty(name = "statusDate", example = "2013-07-27T00:00:00")
    private String statusDate;

    @ApiModelProperty(name = "documentType", example = "1")
    private String documentType;

    @ApiModelProperty(name = "documentNumber", example = "36541463")
    private Long documentNumber;

    @ApiModelProperty(name = "primaryEmail", example = "penelope.cruz@gmail.com")
    private String primaryEmail;

    @ApiModelProperty(name = "secondaryEmail", example = "penelope.cruz2@gmail.com")
    private String secondaryEmail;

    @ApiModelProperty(name = "status", example = "1")
    private Long status;

    @ApiModelProperty(name = "usrPortal", example = "PPEREDABERNARDI")
    private String usrPortal;

    @ApiModelProperty(name = "personType", example = "Estudiante")
    private String personType;

    @ApiModelProperty(name = "locationId", example = "1")
    private Long locationId;

    @ApiModelProperty(name = "provinceId", example = "1")
    private Long provinceId;

    @ApiModelProperty(name = "countryId", example = "4")
    private Long countryId;
    @ApiModelProperty(name = "primaryPhone", example = "1209382")
    private String primaryPhone;

    @ApiModelProperty(name = "secondaryPhone", example = "102830912")
    private String secondaryPhone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }
}
