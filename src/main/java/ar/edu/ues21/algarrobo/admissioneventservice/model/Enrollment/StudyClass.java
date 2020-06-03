package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@ApiModel("StudyClass")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"level"})
public class StudyClass {

    @ApiModelProperty(value = "the StudyClass's id", example = "4")
    private Long id;

    @ApiModelProperty(value = "the StudyClass's name", example = "GRADO PRESENCIAL HOME")
    private String name;

    @ApiModelProperty(value = "the StudyClass's code", example = "4")
    private String code;

    @ApiModelProperty(value = "the StudyClass's state", example = "ACTIVE")
    private State state;

    private List<AttendanceMode> attendanceModes;

    public enum State {
        UNKNOWN, ACTIVE, INACTIVE;
    }

    public boolean isEDN(Long studyClassId) {
        var ednIds = Lists.newArrayList(10L, 13L, 15L, 17L, 18L, 19L, 45L);
        return ednIds.contains(studyClassId);
    }
}
