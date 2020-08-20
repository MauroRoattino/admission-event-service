package ar.edu.ues21.algarrobo.admissioneventservice.model.User.Career;

public class CareerPlans {
    private Long enabled;
    private Long home;
    private CareerPlanId id;

    public Long getEnabled() {
        return enabled;
    }

    public void setEnabled(Long enabled) {
        this.enabled = enabled;
    }

    public Long getHome() {
        return home;
    }

    public void setHome(Long home) {
        this.home = home;
    }

    public CareerPlanId getId() {
        return id;
    }

    public void setId(CareerPlanId id) {
        this.id = id;
    }
}
