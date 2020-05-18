package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel("Locations")
@Entity
@Table(name = "UE_LOCALIDADES", schema = "UE21")
public class Location implements Serializable {

    private static final long serialVersionUID = 1095371181744300551L;

    @ApiModelProperty(value = "location's id", example = "33")
    @Id
    @Column(name = "ID")
    private Long id;

    @ApiModelProperty(value = "location's name", example = "JESUS MARIA")
    @Column(name = "DESCRIPCION")
    private String name;

    @ApiModelProperty(value = "location's province", example = "ARGENTINA")
    @ManyToOne()
    @JoinColumn(name = "PRV_ID")
    private Province province;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Province getProvince() {
        return province;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
