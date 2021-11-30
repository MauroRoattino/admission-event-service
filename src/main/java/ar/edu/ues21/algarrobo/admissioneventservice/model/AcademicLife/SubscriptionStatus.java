package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionStatus {
    @ApiModelProperty(name = "id", dataType = "String", example = "1", notes = "id of the subscription")
    private String id;

    @ApiModelProperty(name = "reason", dataType = "String", example = "feriado", notes = "Reason to update group status")
    private String reason;

    @ApiModelProperty(name = "username", dataType = "String", example = "MCONSOLO", notes = "Username of the person who updated the status")
    private String username;

    @ApiModelProperty(name = "statusId", dataType = "String", example = "2", notes = "Id of the assessment status: \n" +
            "1 = “Creado”\n" +
            "2 = “Habilitado”\n" +
            "3 = “Deshabilitado”\n")
    private String statusId;
}
