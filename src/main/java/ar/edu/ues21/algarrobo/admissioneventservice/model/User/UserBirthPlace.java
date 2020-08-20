package ar.edu.ues21.algarrobo.admissioneventservice.model.User;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Province;
import io.swagger.annotations.ApiModelProperty;

public class UserBirthPlace {

    @ApiModelProperty(name = "id", example = "33")
    private Long id;

    @ApiModelProperty(name = "name", example = "JESUS MARIA")
    private String name;

    private Province province;

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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
