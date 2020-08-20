package ar.edu.ues21.algarrobo.admissioneventservice.model.User;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Location;
import io.swagger.annotations.ApiModelProperty;

public class InstitutionId {
    private Integer cue;
    private String description;
    private Long domId;
    private String email;
    private Integer equivValid;

    @ApiModelProperty(name = "id", example = "33")
    private Long id;
    private Integer kind;
    private Location location;
    private Integer sector;
    private Integer state;

    public Integer getCue() {
        return cue;
    }

    public void setCue(Integer cue) {
        this.cue = cue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDomId() {
        return domId;
    }

    public void setDomId(Long domId) {
        this.domId = domId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEquivValid() {
        return equivValid;
    }

    public void setEquivValid(Integer equivValid) {
        this.equivValid = equivValid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getSector() {
        return sector;
    }

    public void setSector(Integer sector) {
        this.sector = sector;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
