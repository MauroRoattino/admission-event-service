package ar.edu.ues21.algarrobo.admissioneventservice.model.Cau;

import io.swagger.annotations.ApiModelProperty;

public class Location {
    @ApiModelProperty(name = "id", example = "5428")
    private String id;

    @ApiModelProperty(name = "id", example = "MAR DEL PLATA")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
