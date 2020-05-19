package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("Gender")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gender {

    private Long id;

    @ApiModelProperty(value = "name", example = "MASCULINO")
    private String name;

    @ApiModelProperty(value = "code", example = "M")
    private String code;
}
