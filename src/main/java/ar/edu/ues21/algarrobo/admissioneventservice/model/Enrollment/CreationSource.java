package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("CreationSource")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreationSource {

    private String id;

    @ApiModelProperty(value = "name", example = "WEB")
    private String name;
}
