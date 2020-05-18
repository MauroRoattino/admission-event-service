package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Represents all information of an Enrollment
 */
@ApiModel("Enrollment")
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    
    public PreviousStudies getPreviousStudies() {
		return previousStudies;
	}

	public void setPreviousStudies(PreviousStudies previousStudies) {
		this.previousStudies = previousStudies;
	}

	private PreviousStudies previousStudies;

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(final Period period) {
        this.period = period;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StudentRecord getStudentRecord() {
        return studentRecord;
    }

    public void setStudentRecord(final StudentRecord studentRecord) {
        this.studentRecord = studentRecord;
    }

    public List<VTickets> getTickets() {
        return tickets;
    }

    public void setTickets(List<VTickets> tickets) {
        this.tickets = tickets;
    }

	public String getProcessFailure() {
		return processFailure;
	}

	public void setProcessFailure(String processFailure) {
		this.processFailure = processFailure;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}
}