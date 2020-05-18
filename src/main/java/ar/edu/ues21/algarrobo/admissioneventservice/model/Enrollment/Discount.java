package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

public class Discount {

    private String name;

    private boolean fixed;
    private Double percentage;
    private Double ammount;
    private VTickets parent;

    private Discount(String name, boolean fixed, Double percentage, Double ammount, VTickets parent) {
        if (parent == null) {
            throw new IllegalStateException("Parant Ticket shall not be null");
        }
        if (name == null) {
            throw new IllegalStateException("Ticket name shall not be null");
        }
        this.parent = parent;
        this.name = name;
        this.fixed = fixed;
        this.percentage = percentage;
        this.ammount = ammount;
    }

    public static final Discount Fixed(String name, double ammount, VTickets parent) {
        return new Discount(name, true, null, ammount, parent);
    }

    public static final Discount Percentage(String name, double percentage, VTickets parent) {
        return new Discount(name, false, percentage, null, parent);
    }

    public String getName() {
        return this.name;
    }

    public boolean getFixed() {
        return this.fixed;
    }

    public boolean isFixed() {
        return this.fixed;
    }

    public Double getPercentage() {
        if (isFixed()) {
            return this.ammount / this.parent.getBasePrice() * 100d;
        }
        return this.percentage;
    }

    public Double getAmmount() {
        if (!isFixed()) {
            return this.parent.getBasePrice() * percentage / 100d;
        }
        return this.ammount;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", fixed='" + isFixed() + "'" +
            ", percentage='" + getPercentage() + "'" +
            ", ammount='" + getAmmount() + "'" +
            "}";
    }


}