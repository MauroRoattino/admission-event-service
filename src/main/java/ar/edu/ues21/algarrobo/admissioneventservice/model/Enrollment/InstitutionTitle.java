package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel("InstitutionTitle")
@Entity
@Table(name = "UE_TITULOS_INSTITUCIONES", schema = "UE21")
public class InstitutionTitle {

    @ApiModelProperty(value = "Institution Title id", example = "33")
    @Id
    @Column(name = "ID")
    private Long id;

    @ApiModelProperty(value = "description", example = "TECNICO AGRONOMO GENERAL")
    @Column(name = "DESCRIPCION")
    private String description;

    @ApiModelProperty(value = "institutionTitleLevel", example = "1")
    @ManyToOne
    @JoinColumn(name = "GRD_ID")
    private InstitutionTitleLevel institutionTitleLevel;

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

    public InstitutionTitleLevel getInstitutionTitleLevel() {
        return institutionTitleLevel;
    }

    public void setInstitutionTitleLevel(InstitutionTitleLevel institutionTitleLevel) {
        this.institutionTitleLevel = institutionTitleLevel;
    }
}
