package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ApiModel("MaritalStatus")
@Entity
@Table(name = "V_UE_CIVIL", schema = "UE21")
public class MaritalStatus {

    @Id
    private Long id;

    @ApiModelProperty(value = "the marital status", example = "CASADO")
    @Column(name = "NAME")
    private String name;

    @ApiModelProperty(value = "The representation code", example = "C")
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
