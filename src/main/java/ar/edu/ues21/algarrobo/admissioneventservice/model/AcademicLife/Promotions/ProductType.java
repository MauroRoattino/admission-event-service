package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Promotions;

import io.swagger.annotations.ApiModelProperty;

public class ProductType {

    @ApiModelProperty(name = "id", example = "100")
    private int id;

    @ApiModelProperty(name = "description", example = "ticket II para arancel 1")
    private String description;

    @ApiModelProperty(name = "type", example = "II")
    private String type;

    @ApiModelProperty(name = "tariff", example = "1")
    private String tariff;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }
}
