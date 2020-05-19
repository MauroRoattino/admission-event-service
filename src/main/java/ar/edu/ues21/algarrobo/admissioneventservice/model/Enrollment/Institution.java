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

    @ApiModelProperty(value = "institution's id", example = "33")
    private Long id;

    @ApiModelProperty(value = "institution's name")
    private String description;

    @ApiModelProperty(value = "location")
    private Location location;

    @ApiModelProperty(value = "equivValid")
    private Long equivValid;

    @ApiModelProperty(value = "sector")
    private Long sector;

    @ApiModelProperty(value = "state")
    private Long state;

    @ApiModelProperty(value = "domId")
    private Long domId;

    @ApiModelProperty(value = "kind")
    private Long kind;

    @ApiModelProperty(value = "email")
    private String email;

    @ApiModelProperty(value = "cue")
    private Long cue;
}
