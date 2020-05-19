package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * Represents all information of an Enrollment
 */
@ApiModel("Enrollment")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {

    @ApiModelProperty(value = "the period of the enrollment")
    private Period period;

    @ApiModelProperty(value = "the created user")
    private User user;

    @ApiModelProperty(value = "the created student record")
    private StudentRecord studentRecord;

    @ApiModelProperty(value = "the created tickets for the student")
    private List<VTickets> tickets;
    
    private String processFailure;
    
    private String failureMessage;

	private PreviousStudies previousStudies;
}