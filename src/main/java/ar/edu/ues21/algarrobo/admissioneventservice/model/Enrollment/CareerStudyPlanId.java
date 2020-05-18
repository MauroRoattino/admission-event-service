package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
public class CareerStudyPlanId implements Serializable {

    private static final long serialVersionUID = 6292077892803874492L;

    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    @ApiModelProperty(value = "the CareerStudyPlan's career")
    @JsonIgnoreProperties({"plans"})
    private Career career;

    @ManyToOne
    @JoinColumn(name = "PES_ID")
    @ApiModelProperty(value = "the CareerStudyPlan's studyPlan")
    private StudyPlan studyPlan;

    @ManyToOne
    @JoinColumn(name = "CLASE_ESTUDIO")
    @ApiModelProperty(value = "the CareerStudyPlan's studyClass")
    private StudyClass studyClass;

    public Career getCareer() {
        return career;
    }

    public void setCareer(final Career career) {
        this.career = career;
    }

    public StudyPlan getStudyPlan() {
        return studyPlan;
    }

    public void setStudyPlan(final StudyPlan studyPlan) {
        this.studyPlan = studyPlan;
    }

    public StudyClass getStudyClass() {
        return studyClass;
    }

    public void setStudyClass(final StudyClass studyClass) {
        this.studyClass = studyClass;
    }

	@Override
	public int hashCode() {
		final int prime = 75437;
		int result = 1;
		result = prime * result + ((career == null) ? 0 : career.getId().hashCode());
		result = prime * result + ((studyClass == null) ? 0 : studyClass.getId().hashCode());
		result = prime * result + ((studyPlan == null) ? 0 : studyPlan.getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CareerStudyPlanId other = (CareerStudyPlanId) obj;
		if (career == null) {
			if (other.career != null)
				return false;
		} else if (!career.getId().equals(other.career.getId()))
			return false;
		if (studyClass == null) {
			if (other.studyClass != null)
				return false;
		} else if (!studyClass.getId().equals(other.studyClass.getId()))
			return false;
		if (studyPlan == null) {
			if (other.studyPlan != null)
				return false;
		} else if (!studyPlan.getId().equals(other.studyPlan.getId()))
			return false;
		return true;
	}
}
