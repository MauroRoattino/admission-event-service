package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.SubjectStatus;

import io.swagger.annotations.ApiModelProperty;

public class SubjectStatusSubPeriod {

    @ApiModelProperty(name = "id", example = "0")
    private Long id;

    @ApiModelProperty(name = "name", example = "null")
    private String name;

    @ApiModelProperty(name = "from", example = "2012-10-23")
    private String from;

    @ApiModelProperty(name = "to", example = "2012-11-23")
    private String to;

    @ApiModelProperty(name = "description", example = "Curso de Nivelacion 23-Octubre   -2012 - A")
    private String description;

    @ApiModelProperty(name = "subPeriod", example = "null")
    private String subPeriod;

    @ApiModelProperty(name = "enrollment", example = "N")
    private String enrollment;

    @ApiModelProperty(name = "type", example = "5")
    private Long type;

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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubPeriod() {
        return subPeriod;
    }

    public void setSubPeriod(String subPeriod) {
        this.subPeriod = subPeriod;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}
