package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel("Provinces")
@Entity
@Table(name = "UE_PROVINCIAS", schema = "UE21")
public class Province implements Serializable {

    private static final long serialVersionUID = 1095371181744300551L;

    @ApiModelProperty(value = "province's id", example = "1")
    @Id
    @Column(name = "ID")
    private Long id;

    @ApiModelProperty(value = "province's name", example = "CORDOBA")
    @Column(name = "DESCRIPCION")
    private String name;

    @ApiModelProperty(value = "province's country", example = "ARGENTINA")
    @ManyToOne()
    @JoinColumn(name = "PA_ID")
    private Country country;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
