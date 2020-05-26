package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("Career")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Career {

    @ApiModelProperty(value = "the career's id", example = "2")
    private Long id;

    @ApiModelProperty(value = "the career's name", example = "Abogacía")
    private String name;

    @ApiModelProperty(value = "the career's code", example = "VABG")
    private String code;
}