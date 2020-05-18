package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@JsonIgnoreProperties({"contact"})
public class ContactRequestId implements Serializable {

    private static final long serialVersionUID = 341970281333472534L;

    @ManyToOne
    @JoinColumn(name = "INF_ID")
    private Contact contact;

    @Column(name = "ITEM")
    private Long item;

    public Contact getContact() {
        return contact;
    }

    public void setContact(final Contact contact) {
        this.contact = contact;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(final Long item) {
        this.item = item;
    }

	@Override
	public int hashCode() {
		final int prime = 60223;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.getId().hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ContactRequestId))
			return false;
		ContactRequestId other = (ContactRequestId) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}
}
