package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class CareerStudyPlanId {

	@ApiModelProperty(value = "the CareerStudyPlan's career")
	private Career career;

	@ApiModelProperty(value = "the CareerStudyPlan's studyPlan")
	private StudyPlan studyPlan;

	@ApiModelProperty(value = "the CareerStudyPlan's studyClass")
	private StudyClass studyClass;
}
