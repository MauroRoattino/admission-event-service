package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("CareerStudyPlan")
@Entity
@Table(name = "UE_CARRERA_PLANES_ESTUDIOS", schema = "UE21")
public class CareerStudyPlan {

    @EmbeddedId
    private CareerStudyPlanId id;

    @Column(name = "HABILITADA")
    private Integer enabled;

	@Column(name = "HOME")
    private Integer home;


    public CareerStudyPlanId getId() {
        return id;
    }

    public void setId(final CareerStudyPlanId id) {
        this.id = id;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(final Integer enabled) {
        this.enabled = enabled;
    }

    @Transient
    public boolean isEnabled() {
        return Integer.valueOf(1).equals(enabled);
	}
	
	@Transient
    public boolean isHome() {
        return Integer.valueOf(1).equals(home);
	}


	@Override
	public int hashCode() {
		final int prime = 81401;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CareerStudyPlan))
			return false;
		CareerStudyPlan other = (CareerStudyPlan) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getHome() {
		return home;
	}

	public void setHome(Integer home) {
		this.home = home;
	}
}
