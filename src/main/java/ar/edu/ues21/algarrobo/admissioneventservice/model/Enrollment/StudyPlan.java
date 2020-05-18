package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel("StudyPlan")
@Entity
@Table(name = "UE_PLANES_ESTUDIO", schema = "UE21")
public class StudyPlan implements Serializable {

    private static final long serialVersionUID = 6292077892803874492L;

    @ApiModelProperty(value = "the StudyPlan's id")
    @Id
    private Long id;

    @ApiModelProperty(value = "the StudyPlan's name")
    @Column(name = "DESCRIPCION")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

	@Override
	public int hashCode() {
		final int prime = 44119;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StudyPlan))
			return false;
		StudyPlan other = (StudyPlan) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
