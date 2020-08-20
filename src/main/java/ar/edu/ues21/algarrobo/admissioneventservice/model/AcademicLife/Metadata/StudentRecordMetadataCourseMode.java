package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Metadata;

import io.swagger.annotations.ApiModelProperty;

public class StudentRecordMetadataCourseMode {

    @ApiModelProperty(name = "id", example = "3")
    private Long id;

    @ApiModelProperty(name = "name", example = "SIN TURNO")
    private String name;

    @ApiModelProperty(name = "code", example = "3")
    private Integer code;

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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
