package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.SubjectStatus;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.SubjectStatus.SubjectStatusType.SubjectStatusType;
import io.swagger.annotations.ApiModelProperty;

public class SubjectStatus {
    @ApiModelProperty(name = "id", example = "13020")
    private Long id;

    @ApiModelProperty(name = "subjectInscriptionId", example = "0")
    private Long subjectInscriptionId;

    @ApiModelProperty(name = "name", example = "EXAMEN INTEGRADOR CN-FORMAS DE PENSAMIENTO EN LA HUMANIDAD")
    private String name;

    private SubjectStatusStatus status;

    private SubjectStatusType type;

    @ApiModelProperty(name = "validFrom", example = "null")
    private String validFrom;

    @ApiModelProperty(name = "validTo", example = "null")
    private String validTo;

    @ApiModelProperty(name = "classId", example = "0")
    private Long classId;

    @ApiModelProperty(name = "subjectCode", example = "CUR022")
    private String subjectCode;

    private SubjectStatusSubPeriod subPeriod;

    @ApiModelProperty(name = "language", example = "false")
    private Boolean language;

    @ApiModelProperty(name = "blockingActivity", example = "false")
    private Boolean efipReady;

    @ApiModelProperty(name = "efip", example = "false")
    private Boolean efip;

    @ApiModelProperty(name = "language", example = "false")
    private Boolean blockingActivity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectInscriptionId() {
        return subjectInscriptionId;
    }

    public void setSubjectInscriptionId(Long subjectInscriptionId) {
        this.subjectInscriptionId = subjectInscriptionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubjectStatusStatus getStatus() {
        return status;
    }

    public void setStatus(SubjectStatusStatus status) {
        this.status = status;
    }

    public SubjectStatusType getType() {
        return type;
    }

    public void setType(SubjectStatusType type) {
        this.type = type;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidTo() {
        return validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public SubjectStatusSubPeriod getSubPeriod() {
        return subPeriod;
    }

    public void setSubPeriod(SubjectStatusSubPeriod subPeriod) {
        this.subPeriod = subPeriod;
    }

    public Boolean getLanguage() {
        return language;
    }

    public void setLanguage(Boolean language) {
        this.language = language;
    }

    public Boolean getEfipReady() {
        return efipReady;
    }

    public void setEfipReady(Boolean efipReady) {
        this.efipReady = efipReady;
    }

    public Boolean getEfip() {
        return efip;
    }

    public void setEfip(Boolean efip) {
        this.efip = efip;
    }

    public Boolean getBlockingActivity() {
        return blockingActivity;
    }

    public void setBlockingActivity(Boolean blockingActivity) {
        this.blockingActivity = blockingActivity;
    }
}
