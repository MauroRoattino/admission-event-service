package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("DocumentType")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentType {

    private Long id;

    @ApiModelProperty(value = "name", example = "DNI")
    private String name;
}
