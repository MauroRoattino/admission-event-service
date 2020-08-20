package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Status;

import io.swagger.annotations.ApiModelProperty;

public class Flag {
    @ApiModelProperty(name = "id", example = "1")
    private Long id;

    @ApiModelProperty(name = "name", example = "ENROLLMENT_VISIBLE_BY_STATUS")
    private String name;

    @ApiModelProperty(name = "value", example = "1")
    private Integer value;

    @ApiModelProperty(name = "status", example = "2")
    private Integer status;

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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
