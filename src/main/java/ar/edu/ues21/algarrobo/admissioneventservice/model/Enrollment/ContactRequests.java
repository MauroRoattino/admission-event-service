package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@ApiModel("ContactRequest")
@Entity
@Table(name = "UE_INFORMADOS_PEDIDOS", schema = "UE21")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactRequests {

    @EmbeddedId
    private ContactRequestId id;

    @Column(name = "ESTADO_INFORMADOS_PEDIDO")
    private Long Status;

    @Column(name = "FECHA_ESTADO")
    private String statusDate;

    @ApiModelProperty(value = "The attendance mode")
    @Column(name = "TIPO_ESTUDIO")
    private String attendanceMode;

    @ApiModelProperty(value = "The course mode")
    @ManyToOne
    @JoinColumn(name = "TURNOS_CURSADO_CARRERA")
    private CourseMode courseMode;

    @ApiModelProperty(value = "The country")
    @ManyToOne
    @JoinColumn(name = "PA_ID_CURSADO")
    private Country country;

    @ApiModelProperty(value = "The career information")
    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Career career;

    @ApiModelProperty(value = "The user portal information")
    @Column(name = "USR_PORTAL")
    private String usrPortal;

    @ApiModelProperty(value = "The preEnrollment CRM")
    @Column(name = "PREINSCRIPCION_CRM")
    private Long preEnrollmentCrm;

    @ApiModelProperty(value = "The request's date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FECHA_PEDIDO")
    private LocalDate requestDate;


    public ContactRequestId getId() {
        return id;
    }

    public void setId(final ContactRequestId id) {
        this.id = id;
    }

    public Long getStatus() {
        return Status;
    }

    public void setStatus(final Long status) {
        Status = status;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(final String statusDate) {
        this.statusDate = statusDate;
    }

    public String getAttendanceMode() {
        return attendanceMode;
    }

    public void setAttendanceMode(final String attendanceMode) {
        this.attendanceMode = attendanceMode;
    }

    public CourseMode getCourseMode() {
        return courseMode;
    }

    public void setCourseMode(final CourseMode courseMode) {
        this.courseMode = courseMode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(final Country country) {
        this.country = country;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(final Career career) {
        this.career = career;
    }

    public String getUsrPortal() {
        return usrPortal;
    }

    public void setUsrPortal(final String usrPortal) {
        this.usrPortal = usrPortal;
    }

    public Long getPreEnrollmentCrm() {
        return preEnrollmentCrm;
    }

    public void setPreEnrollmentCrm(final Long preEnrollmentCrm) {
        this.preEnrollmentCrm = preEnrollmentCrm;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(final LocalDate requestDate) {
        this.requestDate = requestDate;
    }
}
