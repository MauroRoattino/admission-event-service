package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.SubjectStatus.SubjectStatusType;

import io.swagger.annotations.ApiModelProperty;

public class SubjectId {

    @ApiModelProperty(name = "tipo_materia", example = "10")
    private Long tipo_materia;

    @ApiModelProperty(name = "mat_tipo", example = "NP")
    private String mat_tipo;

    @ApiModelProperty(name = "tipología", example = "00")
    private String tipología;

    @ApiModelProperty(name = "tipoMateriaDescription", example = "INTEGRADORA")
    private String tipoMateriaDescription;

    public Long getTipo_materia() {
        return tipo_materia;
    }

    public void setTipo_materia(Long tipo_materia) {
        this.tipo_materia = tipo_materia;
    }

    public String getMat_tipo() {
        return mat_tipo;
    }

    public void setMat_tipo(String mat_tipo) {
        this.mat_tipo = mat_tipo;
    }

    public String getTipología() {
        return tipología;
    }

    public void setTipología(String tipología) {
        this.tipología = tipología;
    }

    public String getTipoMateriaDescription() {
        return tipoMateriaDescription;
    }

    public void setTipoMateriaDescription(String tipoMateriaDescription) {
        this.tipoMateriaDescription = tipoMateriaDescription;
    }
}

