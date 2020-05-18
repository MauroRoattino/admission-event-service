package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel("InstitutionTitleLevel")
@Entity
@Table(name = "UE_TITULOS_INST_GRADOS", schema = "UE21")
public class InstitutionTitleLevel {

    @ApiModelProperty(value = "Institution Title Level id", example = "33")
    @Id
    @Column(name = "ID")
    private Long id;

    @ApiModelProperty(value = "description", example = "SECUNDARIO")
    @Column(name = "DESCRIPCION")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
