package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.CareerStudyPlan;

import io.swagger.annotations.ApiModelProperty;

public class AcademicLifeCareer {

    @ApiModelProperty(name = "id", example = "21")
    private Long id;

    @ApiModelProperty(name = "name", example = "LICENCIATURA EN PUBLICIDAD")
    private String name;

    @ApiModelProperty(name = "code", example = "VPUB")
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
