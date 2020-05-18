package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("StudentRecord")
@Entity
@Table(name = "UE_ALUMNO_CARRERAS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRecord {

    @Id
    @Column(name = "ID")
    @ApiModelProperty(value = "the StudentRecord's id")
    private String id;

    @JsonIgnore
    @Column(name = "CLIENT_ID_OAUTH")
    private String clientId;

    @Column(name = "FECHA_INGRESO")
    private LocalDateTime startDate;

    @Column(name = "FECHA_ESTADO")
    private LocalDateTime statusDate;

    @Column(name = "ESTADO_ACADEMICO")
    private Long academicStatus;

    @Column(name = "ESTADO_CONTABLE")
    private Long accountantStatus;

    @Column(name = "FECHA_ESTADO_ACAD")
    private LocalDateTime academicStatusDate;

    @Column(name = "FECHA_ESTADO_CONT")
    private LocalDateTime accountantStatusDate;

    @ManyToOne
    @JoinColumn(name = "ALU_ID")
    private Student student;

    @Column(name = "ESTADO_CARRERA")
    private Long status;

    @Column(name = "SED_ID")
    private Long sedId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "CPE_CAR_ID", referencedColumnName = "CAR_ID"),
            @JoinColumn(name = "CPE_PES_ID", referencedColumnName = "PES_ID"),
            @JoinColumn(name = "CPE_CLASE_ESTUDIO", referencedColumnName = "CLASE_ESTUDIO")
    })
    private CareerStudyPlan careerStudyPlan;

    /*@Column(name = "VIGENCIA_DESDE")
    private LocalDate validityFrom;*/

    /*@Column(name = "VIGENCIA_HASTA")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate validityTo;*/

    /*@Column(name = "TRAMITAR_EQUIVALENCIAS")
    private String equivalences;*/

    @Column(name = "FECHA_CURSILLO")
    private Long admissionCourse;

    @Column(name = "ORIGEN_INSCRIPTO")
    private Long origenInscripto;

    @Column(name = "MATRICULA_PAGA")
    private Long enrollmentPaid;

    @Column(name = "INS_ID")
    private Long inscriptionId;

    @JoinColumn(name = "SITE_ID")
    private Long siteId;

    @JoinColumn(name = "TC_INICIO_ID")
    @ManyToOne
    private ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.persistence.Period initialPeriod;

    @Column(name = "USR_PORTAL")
    private String usrPortal;

    @JoinColumn(name = "TURNOS_CURSADO_ZS_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private CourseModeZoneSede courseModeZoneSede;

    /*@Column(name = "EXAMEN_PREVIO")
    private Long exam;*/

    @JoinColumn(name = "SITE_REF_ID")
    private Long siteRefId;

    @JoinColumn(name = "ID_LMS")
    private String idLms;

    @ManyToOne
    @JoinColumn(name = "MODALIDAD_ID")
    private AttendanceMode attendanceMode;

    @Column(name = "ALUMNO_FUTURO")
    private Integer future;

    @Transient
    @ApiModelProperty(value = "student referrer state")
    private RefState refState;

   
    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(final LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(final LocalDateTime statusDate) {
        this.statusDate = statusDate;
    }

    public Long getAcademicStatus() {
        return academicStatus;
    }

    public void setAcademicStatus(final Long academicStatus) {
        this.academicStatus = academicStatus;
    }

    public Long getAccountantStatus() {
        return accountantStatus;
    }

    public void setAccountantStatus(final Long accountantStatus) {
        this.accountantStatus = accountantStatus;
    }

    public LocalDateTime getAcademicStatusDate() {
        return academicStatusDate;
    }

    public void setAcademicStatusDate(final LocalDateTime academicStatusDate) {
        this.academicStatusDate = academicStatusDate;
    }

    public LocalDateTime getAccountantStatusDate() {
        return accountantStatusDate;
    }

    public void setAccountantStatusDate(final LocalDateTime accountantStatusDate) {
        this.accountantStatusDate = accountantStatusDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(final Student student) {
        this.student = student;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(final Long status) {
        this.status = status;
    }

    public Long getSedId() {
        return sedId;
    }

    public void setSedId(final Long sedId) {
        this.sedId = sedId;
    }

    public CareerStudyPlan getCareerStudyPlan() {
        return careerStudyPlan;
    }

    public void setCareerStudyPlan(final CareerStudyPlan careerStudyPlan) {
        this.careerStudyPlan = careerStudyPlan;
    }

    /*public LocalDate getValidityFrom() {
        return validityFrom;
    }

    public void setValidityFrom(final LocalDate validityFrom) {
        this.validityFrom = validityFrom;
    }*/

    /*public LocalDate getValidityTo() {
        return validityTo;
    }

    public void setValidityTo(final LocalDate validityTo) {
        this.validityTo = validityTo;
    }*/

    /*public String getEquivalences() {
        return equivalences;
    }

    public void setEquivalences(final String equivalences) {
        this.equivalences = equivalences;
    }*/

    public Long getAdmissionCourse() {
        return admissionCourse;
    }

    public void setAdmissionCourse(final Long admissionCourse) {
        this.admissionCourse = admissionCourse;
    }

    public Long getOrigenInscripto() {
        return origenInscripto;
    }

    public void setOrigenInscripto(final Long origenInscripto) {
        this.origenInscripto = origenInscripto;
    }

    public Long getEnrollmentPaid() {
        return enrollmentPaid;
    }

    public void setEnrollmentPaid(final Long enrollmentPaid) {
        this.enrollmentPaid = enrollmentPaid;
    }

    public Long getInscriptionId() {
        return inscriptionId;
    }

    public void setInscriptionId(Long inscriptionId) {
        this.inscriptionId = inscriptionId;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(final Long siteId) {
        this.siteId = siteId;
    }

    public ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.persistence.Period getInitialPeriod() {
        return initialPeriod;
    }

    public void setInitialPeriod(ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.persistence.Period period) {
        this.initialPeriod = period;
    }

    public String getUsrPortal() {
        return usrPortal;
    }

    public void setUsrPortal(final String usrPortal) {
        this.usrPortal = usrPortal;
    }

    /*public Long getExam() {
        return exam;
    }

    public void setExam(final Long exam) {
        this.exam = exam;
    }*/

    public CourseModeZoneSede getCourseModeZoneSede() {
        return courseModeZoneSede;
    }

    public void setCourseModeZoneSede(CourseModeZoneSede courseModeZoneSede) {
        this.courseModeZoneSede = courseModeZoneSede;
    }

    public Long getSiteRefId() {
        return siteRefId;
    }

    public void setSiteRefId(final Long siteRefId) {
        this.siteRefId = siteRefId;
    }

    public String getIdLms() {
        return idLms;
    }

    public void setIdLms(String idLms) {
        this.idLms = idLms;
    }

    public AttendanceMode getAttendanceMode() {
        return attendanceMode;
    }

    public void setAttendanceMode(final AttendanceMode attendanceMode) {
        this.attendanceMode = attendanceMode;
    }

    public Integer getFuture() {
        return future;
    }

    public void setFuture(Integer future) {
        this.future = future;
    }

    /*public CourseModeZoneSede getCourseModeZoneSede() {
        return courseModeZoneSede;
    }

    public void setCourseModeZoneSede(final CourseModeZoneSede courseModeZoneSede) {
        this.courseModeZoneSede = courseModeZoneSede;
    }*/

    public RefState getRefState() {
        return refState;
    }

    public void setRefState(final RefState refState) {
        this.refState = refState;
    }

    public StudentType getType(ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.persistence.Period period) {
        if (period.getCode().equals(initialPeriod.getCode())) {
            return StudentType.NI;
        }
        // TODO CHECKEAR QUE LOS ID O LAS FECHAS SEAN POSTERIORES.
        return StudentType.RI;
    }

    @JsonIgnore
    public boolean isDegreePresential() {
        return this.getCareerStudyPlan().getId().getStudyClass().getId().equals(7l);
    }

	@Override
	public int hashCode() {
		final int prime = 49741;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StudentRecord))
			return false;
		StudentRecord other = (StudentRecord) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

    public static class RefState {
        Boolean refAvailable;
        String refMsg;

        public Boolean getRefAvailable() {
            return refAvailable;
        }

        public void setRefAvailable(Boolean refAvailable) {
            this.refAvailable = refAvailable;
        }

        public String getRefMsg() {
            return refMsg;
        }

        public void setRefMsg(String refMsg) {
            this.refMsg = refMsg;
        }

    }

    public enum RefMsg {
        H("Habilitado"),
        MNV("No posee matrícula vigente"),
        MNA("No posee matrícula activa"),
        COUNT("Superó la cantidad permitida de referencias"),
        DIFSC("Pertenece a una modalidad diferente al aspirante");

        RefMsg(String v) {
            this.value = v;
        }

        private final String value;

        public String getValue() {
            return value;
        }
    }
}
