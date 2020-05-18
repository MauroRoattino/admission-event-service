package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@ApiModel("ContactOrigin")
@Entity
@Table(name = "UE_INFORMADOS_ORIGENES", schema = "UE21")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactOrigin {

    @EmbeddedId
    private ContactOriginId id;

    @Column(name = "ESTADO")
    private Long status;

    public ContactOriginId getId() {
        return id;
    }

    public void setId(final ContactOriginId id) {
        this.id = id;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(final Long status) {
        this.status = status;
    }
}
