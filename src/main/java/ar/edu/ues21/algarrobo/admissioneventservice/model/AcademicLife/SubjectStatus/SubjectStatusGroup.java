package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.SubjectStatus;

import io.swagger.annotations.ApiModelProperty;

public class SubjectStatusGroup {
    @ApiModelProperty(name = "id", example = "1")
    private Long id;

    @ApiModelProperty(name = "name", example = "PENDIENTES")
    private String name;

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
}
