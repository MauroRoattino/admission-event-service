package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife;

import io.swagger.annotations.ApiModelProperty;

public class Site {
    @ApiModelProperty(name = "id", example = "S1")
    private String id;

    @ApiModelProperty(name = "name", example = "PRESENCIAL CORDOBA")
    private String name;

    @ApiModelProperty(name = "code", example = "PRESENCIAL CORDOBA")
    private String code;

    @ApiModelProperty(name = "location", example = "SIN DATOS")
    private String location;

    @ApiModelProperty(name = "sedId", example = "1")
    private Integer sedId;

    @ApiModelProperty(name = "siteId", example = "3")
    private Integer siteId;

    @ApiModelProperty(name = "siteRefId", example = "null")
    private Integer siteRefId;

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

    public Integer getSedId() {
        return sedId;
    }

    public void setSedId(Integer sedId) {
        this.sedId = sedId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getSiteRefId() {
        return siteRefId;
    }

    public void setSiteRefId(Integer siteRefId) {
        this.siteRefId = siteRefId;
    }

    public String getType(){
        if (id != null) {
            if (id.startsWith("C")) {
                return "CAU";
            } else {
                return "SEDE";
            }
        }
        return null;
    }
}
