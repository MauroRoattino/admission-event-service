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
@ApiModel("Enrollment")
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
}