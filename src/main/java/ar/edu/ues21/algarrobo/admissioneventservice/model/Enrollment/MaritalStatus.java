package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("MaritalStatus")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaritalStatus {

    @ApiModelProperty(value = "Id", example = "1")
    private Long id;

    @ApiModelProperty(value = "the marital status", example = "SOLTERO")
    private String name;

    @ApiModelProperty(value = "The representation code", example = "S")
    private String code;
}
