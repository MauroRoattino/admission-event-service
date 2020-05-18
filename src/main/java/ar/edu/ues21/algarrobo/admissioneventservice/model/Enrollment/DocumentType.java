package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel("DocumentType")
@Entity
@Table(name = "V_UE_TIPO_DOCUMENTO", schema = "UE21")
public class DocumentType {

    @Id
    private Long id;

    @ApiModelProperty(value = "name", example = "DNI")
    @Column(name = "NOMBRE")
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
}
