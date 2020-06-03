package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("CourseMode")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class CourseMode {

    @ApiModelProperty(value = "the CourseMode's id", example = "1")
    private Long id;

    @ApiModelProperty(value = "the CourseMode's code", example = "1")
    private String code;

    @ApiModelProperty(value = "the CourseMode's name", example = "Mañana")
    private String name;
}
