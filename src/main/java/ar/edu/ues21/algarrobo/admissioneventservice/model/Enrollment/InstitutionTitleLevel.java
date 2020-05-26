package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("InstitutionTitleLevel")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstitutionTitleLevel {

    @ApiModelProperty(value = "Institution Title Level id", example = "33")
    private Long id;

    @ApiModelProperty(value = "description", example = "SECUNDARIO")
    private String description;
}
