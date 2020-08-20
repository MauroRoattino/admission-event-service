package ar.edu.ues21.algarrobo.admissioneventservice.model.User.Origin;

public class UserOrigin {
    private UserOriginId id;
    private Integer status;

    public UserOriginId getId() {
        return id;
    }

    public void setId(UserOriginId id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
