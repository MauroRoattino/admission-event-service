package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "If this field is null in the incoming request, it will be populated with default values (_SIN DATOS_)")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @ApiModelProperty(value = "location's id", example = "42")
    private Long id;

    @ApiModelProperty(value = "location's name", example = "MALAGUEÑO")
    private String name;

    @ApiModelProperty(value = "location's province")
    private Province province;
}
