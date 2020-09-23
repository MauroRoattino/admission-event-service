package ar.edu.ues21.algarrobo.admissioneventservice.model;

public class ErrorEvent {

    private String id;
    private String errorMessage;

    public ErrorEvent(String id, String errorMessage) {
        this.id = id;
        this.errorMessage = errorMessage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
