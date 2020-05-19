package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("AttendanceMode")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceMode {

    @ApiModelProperty(value = "the AttendanceMode's id")
    private Long id;

    @ApiModelProperty(value = "the AttendanceMode's code", example = "1")
    private String code;

    @ApiModelProperty(value = "the AttendanceMode's name", example = "Distancia - ED HOME")
    private String name;

    @ApiModelProperty(value = "the AttendanceMode's grouo", example = "D")
    private String group;
}
