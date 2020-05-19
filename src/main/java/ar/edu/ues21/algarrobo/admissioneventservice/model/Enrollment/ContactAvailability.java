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
public class ContactAvailability {

    @ApiModelProperty(value = "id", example = "157654")
    private String id;

    @ApiModelProperty(value = "name", example = "MAÑANA")
    private String name;
}
