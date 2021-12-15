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

    @ApiModelProperty(value = "subscription id ", example = "2c955f76-7c2c-465c-a7ea-a7c72ae04296")
    private String id;

    @ApiModelProperty(value = "assessment group id ", example = "2c955f76-7c2c-465c-a7ea-a7c72ae04296")
    private String assessmentGroupId;

    @ApiModelProperty(value = "external course id", example = "1050")
    private String externalCourseId;

    @ApiModelProperty(value = "id" , example = "1")
    private String externalId;

    private SubscriptionStatus status;

    @ApiModelProperty(value = "last name", example = "Perez")
    private String lastName;

    @ApiModelProperty(value = "student's first name", example = "Romina")
    private String name;

    @ApiModelProperty(value = "settings id", example = "e6768b41-6405-4c43-8eb5-935ed28b5fc9")
    private String settingSubjectId;

    @ApiModelProperty(value = "username", example = "rominaperez")
    private String username;

}
