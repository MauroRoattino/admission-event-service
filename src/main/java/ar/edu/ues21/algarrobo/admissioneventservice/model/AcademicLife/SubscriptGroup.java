package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptGroup {

    @ApiModelProperty(value = "external course id")
    private String externalCourseId;

    @ApiModelProperty(value = "id")
    private String externalId;

    @ApiModelProperty(value = "last name")
    private String lastName;

    @ApiModelProperty(value = "subscript group name")
    private String name;

    @ApiModelProperty(value = "settings id")
    private String settingSubjectId;

    @ApiModelProperty(value = "subject id")
    private String subjectId;

    @ApiModelProperty(value = "user name")
    private String username;

}
