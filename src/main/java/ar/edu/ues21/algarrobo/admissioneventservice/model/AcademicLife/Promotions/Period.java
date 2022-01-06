package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Promotions;

import io.swagger.annotations.ApiModelProperty;

public class Period {

    @ApiModelProperty(name = "code", example = "2/17")
    private String code;

    @ApiModelProperty(name = "id", example = "5927")
    private int id;

    @ApiModelProperty(name = "tipo", example = "3")
    private int tipo;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
