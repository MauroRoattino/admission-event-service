package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import javax.persistence.*;

/**
 * Class that represents the course mode zone for the sede
 */
@Entity
@Table(name = "UE_TURNOS_CURSADO_ZONA_SEDE", schema = "UE21")
public class CourseModeZoneSede {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_SEDE")
    private Long sedeId;

    @Column(name = "ID_STZ")
    private Long zoneId;

    @ManyToOne
    @JoinColumn(name = "TURNO_CURSADO_CARRERA")
    private CourseMode courseMode;

    @Column(name = "ZONA_CURSADO")
    private Long zone;

    @Column(name = "ESTADO")
    private Long status;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getSedeId() {
        return sedeId;
    }

    public void setSedeId(final Long sedeId) {
        this.sedeId = sedeId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(final Long zoneId) {
        this.zoneId = zoneId;
    }

    public CourseMode getCourseMode() {
        return courseMode;
    }

    public void setCourseMode(final CourseMode courseMode) {
        this.courseMode = courseMode;
    }

    public Long getZone() {
        return zone;
    }

    public void setZone(final Long zone) {
        this.zone = zone;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(final Long status) {
        this.status = status;
    }
}
