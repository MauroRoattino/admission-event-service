package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("Institution")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Institution {

    @ApiModelProperty(value = "institution's id", example = "414")
    private Long id;

    @ApiModelProperty(value = "institution's name", example = "UNIVERSIDAD NACIONAL DE TUCUMÁN")
    private String description;

    @ApiModelProperty(value = "location")
    private Location location;

    @ApiModelProperty(value = "equivValid", example = "2")
    private Long equivValid;

    @ApiModelProperty(value = "sector", example = "2")
    private Long sector;

    @ApiModelProperty(value = "state", example = "2")
    private Long state;

    @ApiModelProperty(value = "domId", example = "1")
    private Long domId;

    @ApiModelProperty(value = "kind", example = "1")
    private Long kind;

    @ApiModelProperty(value = "email", example = "-")
    private String email;

    @ApiModelProperty(value = "cue", example = "1")
    private Long cue;
}
