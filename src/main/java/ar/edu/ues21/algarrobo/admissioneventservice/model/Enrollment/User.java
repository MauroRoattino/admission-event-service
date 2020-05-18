package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import java.time.LocalDateTime;

public class User {

    private Long id;

    private String usrPortal;

    private String active;
    
    private LocalDateTime fromDate;

    private LocalDateTime passwordExpiration;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUsrPortal() {
        return usrPortal;
    }

    public void setUsrPortal(final String usrPortal) {
        this.usrPortal = usrPortal;
    }

    public String getActive() {
        return active;
    }

    public void setActive(final String active) {
        this.active = active;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(final LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getPasswordExpiration() {
        return passwordExpiration;
    }

    public void setPasswordExpiration(final LocalDateTime passwordExpiration) {
        this.passwordExpiration = passwordExpiration;
    }
}