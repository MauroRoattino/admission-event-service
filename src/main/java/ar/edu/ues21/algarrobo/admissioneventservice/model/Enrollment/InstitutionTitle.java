package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("InstitutionTitle")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstitutionTitle {

    @ApiModelProperty(value = "Institution Title id", example = "33")
    private Long id;

    @ApiModelProperty(value = "description", example = "TECNICO AGRONOMO GENERAL")
    private String description;

    @ApiModelProperty(value = "institutionTitleLevel")
    private InstitutionTitleLevel institutionTitleLevel;
}
