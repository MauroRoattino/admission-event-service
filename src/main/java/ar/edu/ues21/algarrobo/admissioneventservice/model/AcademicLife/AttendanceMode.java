package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife;

import io.swagger.annotations.ApiModelProperty;

public class AttendanceMode {

    @ApiModelProperty(name = "id", example = "4")
    private Long id;

    @ApiModelProperty(name = "description", example = "PRESENCIAL")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
