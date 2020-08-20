package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicOffer;

import io.swagger.annotations.ApiModelProperty;

public class CareerAcademicOffer {
    @ApiModelProperty(value = "id", example = "2")
    private Long id;

    @ApiModelProperty(value = "name", example = "Abogacía")
    private String name;

    @ApiModelProperty(value = "code", example = "VABG")
    private String code;

    @ApiModelProperty(value = "state", example = "ACTIVE")
    private String state;

    @ApiModelProperty(value = "comercialName", example = "Abogacía")
    private String comercialName;

    @ApiModelProperty(value = "careerType", example = "-")
    private String careerType;

    @ApiModelProperty(value = "cycle", example = "-")
    private String cycle;

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

    public String getComercialName() {
        return comercialName;
    }

    public void setComercialName(String comercialName) {
        this.comercialName = comercialName;
    }

    public String getCareerType() {
        return careerType;
    }

    public void setCareerType(String careerType) {
        this.careerType = careerType;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
}
