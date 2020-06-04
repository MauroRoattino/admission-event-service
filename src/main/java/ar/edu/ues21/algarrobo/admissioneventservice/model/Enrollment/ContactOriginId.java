package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactOriginId {

    private Contact contact;

    @ApiModelProperty(example = "12")
    private Long origin;
}
