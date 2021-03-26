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

    @ApiModelProperty(value = "external course id", example = "1050")
    private String externalCourseId;

    @ApiModelProperty(value = "id" , example = "1")
    private String externalId;

    @ApiModelProperty(value = "last name", example = "Perez")
    private String lastName;

    @ApiModelProperty(value = "subscript group name", example = "Romina")
    private String name;

    @ApiModelProperty(value = "settings id", example = "1")
    private String settingSubjectId;

    @ApiModelProperty(value = "subject id", example = "1")
    private String subjectId;

    @ApiModelProperty(value = "user name", example = "rominaperez")
    private String username;

}
