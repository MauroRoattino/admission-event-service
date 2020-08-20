package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Metadata;

import io.swagger.annotations.ApiModelProperty;

public class StudentRecordMetadata {

    @ApiModelProperty(name = "admissionCourse", example = "6331")
    private Long admissionCourse;

    @ApiModelProperty(name = "origenInscripto", example = "3")
    private Integer origenInscripto;

    @ApiModelProperty(name = "clientId", example = "null")
    private String clientId;

    @ApiModelProperty(name = "usrPortal", example = "FDIESSLER")
    private String usrPortal;

    @ApiModelProperty(name = "courseModeZoneSede", example = "1")
    private Integer courseModeZoneSede;

    @ApiModelProperty(name = "enrollmentPaid", example = "1")
    private Integer enrollmentPaid;

    @ApiModelProperty(name = "inscriptionId", example = "1")
    private Integer inscriptionId;

    @ApiModelProperty(name = "initialPeriod", example = "3544")
    private Integer initialPeriod;

    @ApiModelProperty(name = "idLms", example = "null")
    private String idLms;

    @ApiModelProperty(name = "future", example = "0")
    private String future;

    private StudentRecordMetadataCourseMode courseMode;

    public Long getAdmissionCourse() {
        return admissionCourse;
    }

    public void setAdmissionCourse(Long admissionCourse) {
        this.admissionCourse = admissionCourse;
    }

    public Integer getOrigenInscripto() {
        return origenInscripto;
    }

    public void setOrigenInscripto(Integer origenInscripto) {
        this.origenInscripto = origenInscripto;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUsrPortal() {
        return usrPortal;
    }

    public void setUsrPortal(String usrPortal) {
        this.usrPortal = usrPortal;
    }

    public Integer getCourseModeZoneSede() {
        return courseModeZoneSede;
    }

    public void setCourseModeZoneSede(Integer courseModeZoneSede) {
        this.courseModeZoneSede = courseModeZoneSede;
    }

    public Integer getEnrollmentPaid() {
        return enrollmentPaid;
    }

    public void setEnrollmentPaid(Integer enrollmentPaid) {
        this.enrollmentPaid = enrollmentPaid;
    }

    public Integer getInscriptionId() {
        return inscriptionId;
    }

    public void setInscriptionId(Integer inscriptionId) {
        this.inscriptionId = inscriptionId;
    }

    public Integer getInitialPeriod() {
        return initialPeriod;
    }

    public void setInitialPeriod(Integer initialPeriod) {
        this.initialPeriod = initialPeriod;
    }

    public String getIdLms() {
        return idLms;
    }

    public void setIdLms(String idLms) {
        this.idLms = idLms;
    }

    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
    }

    public StudentRecordMetadataCourseMode getCourseMode() {
        return courseMode;
    }

    public void setCourseMode(StudentRecordMetadataCourseMode courseMode) {
        this.courseMode = courseMode;
    }
}
