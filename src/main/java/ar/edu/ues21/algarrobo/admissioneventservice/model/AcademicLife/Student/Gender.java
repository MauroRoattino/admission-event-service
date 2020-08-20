package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Student;

import io.swagger.annotations.ApiModelProperty;

public class Gender {
    @ApiModelProperty(name = "id", example = "1")
    private String id;

    @ApiModelProperty(name = "description", example = "FEMENINO")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
