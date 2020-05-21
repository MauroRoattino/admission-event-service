package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("ContactOrigin")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactOrigin {

    private ContactOriginId id;

    @ApiModelProperty(example = "3")
    private Long status;
}
