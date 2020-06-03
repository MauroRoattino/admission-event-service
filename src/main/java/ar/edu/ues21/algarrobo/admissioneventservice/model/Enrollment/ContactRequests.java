package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@JsonInclude(Include.NON_NULL)
public class ContactRequests {

    private ContactRequestId id;

    @ApiModelProperty(example = "2")
    private Long Status;

    @ApiModelProperty(example = "19-FEB-03")
    private String statusDate;

    @ApiModelProperty(value = "The attendance mode", example = "1")
    private String attendanceMode;

    @ApiModelProperty(value = "The course mode")
    private CourseMode courseMode;

    @ApiModelProperty(value = "The country")
    private Country country;

    @ApiModelProperty(value = "The career information")
    private Career career;

    @ApiModelProperty(value = "The user portal information", example = "CRSANCHEZ")
    private String usrPortal;

    @ApiModelProperty(value = "The preEnrollment CRM", example = "1")
    private Long preEnrollmentCrm;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "The request's date", example="2019-06-31")
    private LocalDate requestDate;
}
