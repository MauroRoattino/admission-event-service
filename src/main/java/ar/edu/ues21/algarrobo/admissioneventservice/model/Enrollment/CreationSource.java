package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel("CreationSource")
@Entity
@Table(name = "V_UE_ORIGEN_INFORMADO", schema = "UE21")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreationSource {

    @Id
    private String id;

    @ApiModelProperty(value = "name", example = "WEB")
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
