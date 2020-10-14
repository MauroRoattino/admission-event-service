package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife;

public class Irregularity {
    private String subject;
    private String message;

    public Irregularity() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

