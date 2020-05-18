package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@JsonIgnoreProperties({"contact"})
public class ContactOriginId implements Serializable {

   

	private static final long serialVersionUID = 1873317560874712350L;

    @ManyToOne
    @JoinColumn(name = "INF_ID")
    private Contact contact;

    @Column(name = "ORIGEN")
    private Long origin;

    public Contact getContact() {
        return contact;
    }

    public void setContact(final Contact contact) {
        this.contact = contact;
    }

    public Long getOrigin() {
        return origin;
    }

    public void setOrigin(final Long origin) {
        this.origin = origin;
    }
    
    @Override
   	public int hashCode() {
   		final int prime = 14243;
   		int result = 1;
   		result = prime * result + ((contact == null) ? 0 : contact.getId().hashCode());
   		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
   		return result;
   	}

   	@Override
   	public boolean equals(Object obj) {
   		if (this == obj)
   			return true;
   		if (!(obj instanceof ContactOriginId))
   			return false;
   		ContactOriginId other = (ContactOriginId) obj;
   		if (contact == null) {
   			if (other.contact != null)
   				return false;
   		} else if (!contact.equals(other.contact))
   			return false;
   		if (origin == null) {
   			if (other.origin != null)
   				return false;
   		} else if (!origin.equals(other.origin))
   			return false;
   		return true;
   	}
}
