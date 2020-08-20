package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife;

import io.swagger.annotations.ApiModelProperty;

public class Sede {

    @ApiModelProperty(name = "id", example = "C1002")
    private String id;

    @ApiModelProperty(name = "name", example = "ASOCIACIÓN DE ESTUDIOS SUPERIORES RÍO QUEQUÉN")
    private String name;

    @ApiModelProperty(name = "code", example = "NEC01")
    private String code;

    @ApiModelProperty(name = "location", example = "NECOCHEA")
    private String location;

    @ApiModelProperty(name = "province", example = "BUENOS AIRES")
    private String province;

    @ApiModelProperty(name = "country", example = "ARGENTINA")
    private String country;

    @ApiModelProperty(name = "state", example = "ACTIVE")
    private String state;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
