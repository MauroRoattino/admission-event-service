package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife;

import io.swagger.annotations.ApiModelProperty;

public class AcademicLifePeriod {
    @ApiModelProperty(name = "id", example = "7053")
    private Long id;

    @ApiModelProperty(name = "name", example = "01/02")
    private String name;

    @ApiModelProperty(name = "from", example = "2020-01-01")
    private String from;

    @ApiModelProperty(name = "to", example = "2020-03-31")
    private String to;

    @ApiModelProperty(name = "description", example = "Periodo 1/20 VERANO")
    private String description;

    @ApiModelProperty(name = "subperiod", example = "A")
    private String subperiod;

    @ApiModelProperty(name = "enrollment", example = "N")
    private String enrollment;

    @ApiModelProperty(name = "type", example = "1")
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

    public String getSubperiod() {
        return subperiod;
    }

    public void setSubperiod(String subperiod) {
        this.subperiod = subperiod;
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
