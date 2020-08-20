package ar.edu.ues21.algarrobo.admissioneventservice.model.User;

import io.swagger.annotations.ApiModelProperty;

public class UserNationality {

    @ApiModelProperty(name = "id", example = "1")
    private Long id;

    @ApiModelProperty(name = "name", example = "ARGENTINA")
    private String name;

    @ApiModelProperty(name = "nationality", example = "ARGENTINA")
    private String nationality;

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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
