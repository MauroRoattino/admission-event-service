package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
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

    private Long status;

}
