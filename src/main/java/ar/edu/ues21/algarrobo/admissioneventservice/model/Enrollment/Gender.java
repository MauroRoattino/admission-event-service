package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ApiModel("Gender")
@Entity
@Table(name = "V_UE_SEXO", schema = "UE21")
public class Gender {

    @Id
    private Long id;

    @ApiModelProperty(value = "name", example = "MASCULINO")
    @Column(name = "NAME")
    private String name;

    @ApiModelProperty(value = "code", example = "M")
    @Column(name = "SQL_CODE")
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

    public void setCode(final String code) {
        this.code = code;
    }
}
