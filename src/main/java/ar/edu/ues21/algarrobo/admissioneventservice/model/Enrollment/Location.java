package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("Locations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @ApiModelProperty(value = "location's id", example = "33")
    private Long id;

    @ApiModelProperty(value = "location's name", example = "JESUS MARIA")
    private String name;

    @ApiModelProperty(value = "location's province", example = "ARGENTINA")
    private Province province;
}
