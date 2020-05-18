package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;


@ApiModel("Institution")
@Entity
@Table(name = "UE_INSTITUCIONES_EDUCATIVAS", schema = "UE21")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties("location")
public class Institution {

    @ApiModelProperty(value = "institution's id", example = "33")
    @Id
    @Column(name = "ID")
    private Long id;

    @ApiModelProperty(value = "institution's name")
    @Column(name = "DESCRIPCION")
    private String description;

    @ApiModelProperty(value = "location")
    @ManyToOne
    @JoinColumn(name = "LOC_ID")
    private Location location;

    @ApiModelProperty(value = "equivValid")
    @Column(name = "VALIDO_EQUIV")
    private Long equivValid;

    @ApiModelProperty(value = "sector")
    @Column(name = "SECTOR")
    private Long sector;

    @ApiModelProperty(value = "state")
    @Column(name = "ESTADO")
    private Long state;

    @ApiModelProperty(value = "domId")
    @Column(name = "DOM_ID")
    private Long domId;

    @ApiModelProperty(value = "kind")
    @Column(name = "TIPO")
    private Long kind;

    @ApiModelProperty(value = "email")
    @Column(name = "EMAIL")
    private String email;

    @ApiModelProperty(value = "cue")
    @Column(name = "CUE")
    private Long cue;

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getEquivValid() {
        return equivValid;
    }

    public void setEquivValid(Long equivValid) {
        this.equivValid = equivValid;
    }

    public Long getSector() {
        return sector;
    }

    public void setSector(Long sector) {
        this.sector = sector;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getDomId() {
        return domId;
    }

    public void setDomId(Long domId) {
        this.domId = domId;
    }

    public Long getKind() {
        return kind;
    }

    public void setKind(Long kind) {
        this.kind = kind;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCue() {
        return cue;
    }

    public void setCue(Long cue) {
        this.cue = cue;
    }
}
