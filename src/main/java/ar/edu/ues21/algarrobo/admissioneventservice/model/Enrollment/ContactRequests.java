package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@ApiModel("ContactRequest")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequests {

    private ContactRequestId id;

    private Long Status;

    private String statusDate;

    @ApiModelProperty(value = "The attendance mode")
    private String attendanceMode;

    @ApiModelProperty(value = "The course mode")
    private CourseMode courseMode;

    @ApiModelProperty(value = "The country")
    private Country country;

    @ApiModelProperty(value = "The career information")
    private Career career;

    @ApiModelProperty(value = "The user portal information")
    private String usrPortal;

    @ApiModelProperty(value = "The preEnrollment CRM")
    private Long preEnrollmentCrm;

    @ApiModelProperty(value = "The request's date")
    private LocalDate requestDate;
}
