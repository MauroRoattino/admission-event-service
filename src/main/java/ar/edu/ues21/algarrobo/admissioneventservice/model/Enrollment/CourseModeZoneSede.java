package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class that represents the course mode zone for the sede
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseModeZoneSede {

    @ApiModelProperty(example = "3")
    private Long id;

    @ApiModelProperty(example = "4")
    private Long sedeId;

    @ApiModelProperty(example = "131")
    private Long zoneId;

    private CourseMode courseMode;

    @ApiModelProperty(example = "2")
    private Long zone;

    @ApiModelProperty(example = "1")
    private Long status;
}
