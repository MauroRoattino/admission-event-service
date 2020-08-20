package ar.edu.ues21.algarrobo.admissioneventservice.model.User;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.InstitutionTitleLevel;
import io.swagger.annotations.ApiModelProperty;

public class TitleId {

    @ApiModelProperty(name = "description", example = "SECUNDARIO")
    private String description;

    @ApiModelProperty(name = "id", example = "33")
    private Long id;
    private InstitutionTitleLevel institutionTitleLevel;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InstitutionTitleLevel getInstitutionTitleLevel() {
        return institutionTitleLevel;
    }

    public void setInstitutionTitleLevel(InstitutionTitleLevel institutionTitleLevel) {
        this.institutionTitleLevel = institutionTitleLevel;
    }
}
