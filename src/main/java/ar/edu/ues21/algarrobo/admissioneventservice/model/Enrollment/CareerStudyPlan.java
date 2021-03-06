package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("CareerStudyPlan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CareerStudyPlan {

    private CareerStudyPlanId id;

    @ApiModelProperty(example = "2")
    private Integer enabled;

    @ApiModelProperty(example = "2")
    private Integer home;

}
