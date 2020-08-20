package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicOffer;

import io.swagger.annotations.ApiModelProperty;

public class CourseModeAcademicOffer {
    @ApiModelProperty(name = "id", example = "3")
    private String id;

    @ApiModelProperty(name = "id", example = "SIN TURNO")
    private String name;

    @ApiModelProperty(name = "code", example = "3")
    private String code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
