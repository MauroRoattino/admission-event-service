package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Promotions;

import io.swagger.annotations.ApiModelProperty;

public class Document {

    @ApiModelProperty(name = "id", example = "4")
    private int id;

    @ApiModelProperty(name = "description", example = "Certificado de alumno regular")
    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
