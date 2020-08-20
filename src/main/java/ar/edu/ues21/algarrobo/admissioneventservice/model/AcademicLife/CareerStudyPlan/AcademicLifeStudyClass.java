package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.CareerStudyPlan;

import io.swagger.annotations.ApiModelProperty;

public class AcademicLifeStudyClass {
    @ApiModelProperty(name = "id", example = "21")
    private Long id;

    @ApiModelProperty(name = "name", example = "GRADO PRESENCIAL")
    private String name;

    @ApiModelProperty(name = "code", example = "7")
    private String code;

    @ApiModelProperty(name = "state", example = "ACTIVE")
    private String state;

    @ApiModelProperty(name = "level", example = "DEGREE")
    private String level;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
