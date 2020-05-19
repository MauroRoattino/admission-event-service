package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
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

    private Integer enabled;

    private Integer home;

}
