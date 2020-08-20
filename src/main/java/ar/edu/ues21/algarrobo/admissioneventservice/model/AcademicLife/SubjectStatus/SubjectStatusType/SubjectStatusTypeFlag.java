package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.SubjectStatus.SubjectStatusType;

import io.swagger.annotations.ApiModelProperty;

public class SubjectStatusTypeFlag {

    @ApiModelProperty(name = "description", example = "El tipo de materia requiere examen final")
    private String description;

    @ApiModelProperty(name = "name", example = "FINAL_REQUIRED")
    private String name;

    @ApiModelProperty(name = "value", example = "1")
    private Long value;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
