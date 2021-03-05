package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents all information of an Enrollment
 */
@ApiModel(value = "Enrollment", description = "This Enrollment is retrieved from the " +
        "[Admission API](https://api.ues21.edu.ar/admission-api/api/swagger-ui.html#/default-enrollment-controller/getContextUsingGET)")
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

    @ApiModelProperty(example = "Tickets")
    private String processFailure;

    @ApiModelProperty(example = "Failed to generate tickets for: ABG01798")
    private String failureMessage;

	private PreviousStudies previousStudies;
	
	 @ApiModelProperty(value = "the opportunity detail id")
	 private String opportunityDetailId;
	
	 @ApiModelProperty(value = "the student's site")
     private Site site;
     
     @ApiModelProperty(value = "indicate the source of enrrollment source is a batch process from a private datasource")
     private boolean massive;
	
}