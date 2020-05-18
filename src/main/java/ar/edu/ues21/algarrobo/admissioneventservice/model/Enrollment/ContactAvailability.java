package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel("DocumentType")
@Entity
@Table(name = "V_UE_HORARIO_CONTACTO", schema = "UE21")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactAvailability {

    @Id
    private String id;

    @ApiModelProperty(value = "name", example = "MAÑANA")
    @Column(name = "NOMBRE")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
