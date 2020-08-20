package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicOffer;

import io.swagger.annotations.ApiModelProperty;

public class AttendanceModeAcademicOffer {
    @ApiModelProperty(name = "id", example = "1")
    private String id;

    @ApiModelProperty(name = "id", example = "DISTANCIA - ED HOME")
    private String name;

    @ApiModelProperty(name = "code", example = "1")
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
