package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("StudyPlan")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyPlan{

    @ApiModelProperty(value = "the StudyPlan's id", example = "2007")
    private Long id;

    @ApiModelProperty(value = "the StudyPlan's name", example = "PLAN 2007")
    private String name;
}
