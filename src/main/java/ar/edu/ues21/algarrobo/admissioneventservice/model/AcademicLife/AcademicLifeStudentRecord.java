package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.CareerStudyPlan.AcademicLifeCareerStudyPlan;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Metadata.StudentRecordMetadata;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Metadata.StudentRecordMetadataCourseMode;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Status.StudentRecordStatus;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Student.AcademicLifeStudent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.SubjectStatus.SubjectStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@ApiModel(description = "This student record is retrieved from the " +
        "[student-record API](https://api.ues21.edu.ar/student-records/api/swagger-ui.html#/Student%20Record/getStudentsWithFiltersUsingGET).")
public class AcademicLifeStudentRecord {

    @ApiModelProperty(name = "id", example = "PUB01287")
    private String id;

    @ApiModelProperty(value = "startDate", example = "2012-09-18 00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;

    private StudentRecordMetadata metadata;

    private StudentRecordStatus status;

    private StudentRecordStatus academicStatus;

    private StudentRecordStatus accountantStatus;

    private AttendanceMode attendanceMode;

    private Site site;

    private AcademicLifeCau cau;

    private String personType;

    private Sede sede;

    private AcademicLifeStudent student;

    private AcademicLifeCareerStudyPlan careerStudyPlan;

    private AcademicLifePeriod initialPeriod;

    private AcademicLifePeriod lastPeriod;

    @ApiModelProperty(name = "graduateDate", example = "2020-07-27T00:00:00",
                    notes = "If the status.id is equal to 16, then this field will be populated with the status.date")
    private String graduateDate;

    private List<SubjectStatus> subjectStatus;

    @ApiModelProperty(name = "examRightsQty", example = "0")
    private String examRightsQty;

    @ApiModelProperty(name = "irregularities", example = "[]")
    private List<Irregularity> irregularities;

    @ApiModelProperty(name = "disablings", example = "[]")
    private List<String> disablings;

    @ApiModelProperty(name = "efip_dif", example = "0")
    private Integer efip_dif;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date validFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date validTo;

    private StudentRecordMetadataCourseMode courseMode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public StudentRecordMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(StudentRecordMetadata metadata) {
        this.metadata = metadata;
    }

    public StudentRecordStatus getStatus() {
        return status;
    }

    public void setStatus(StudentRecordStatus status) {
        this.status = status;
    }

    public StudentRecordStatus getAcademicStatus() {
        return academicStatus;
    }

    public void setAcademicStatus(StudentRecordStatus academicStatus) {
        this.academicStatus = academicStatus;
    }

    public StudentRecordStatus getAccountantStatus() {
        return accountantStatus;
    }

    public void setAccountantStatus(StudentRecordStatus accountantStatus) {
        this.accountantStatus = accountantStatus;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public AcademicLifeCau getCau() {
        return cau;
    }

    public void setCau(AcademicLifeCau cau) {
        this.cau = cau;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public AcademicLifeStudent getStudent() {
        return student;
    }

    public void setStudent(AcademicLifeStudent student) {
        this.student = student;
    }

    public AcademicLifeCareerStudyPlan getCareerStudyPlan() {
        return careerStudyPlan;
    }

    public void setCareerStudyPlan(AcademicLifeCareerStudyPlan careerStudyPlan) {
        this.careerStudyPlan = careerStudyPlan;
    }

    public AcademicLifePeriod getInitialPeriod() {
        return initialPeriod;
    }

    public void setInitialPeriod(AcademicLifePeriod initialPeriod) {
        this.initialPeriod = initialPeriod;
    }

    public AcademicLifePeriod getLastPeriod() {
        return lastPeriod;
    }

    public void setLastPeriod(AcademicLifePeriod lastPeriod) {
        this.lastPeriod = lastPeriod;
    }

    public String getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(String graduateDate) {
        this.graduateDate = graduateDate;
    }

    public List<SubjectStatus> getSubjectStatus() {
        return subjectStatus;
    }

    public void setSubjectStatus(List<SubjectStatus> subjectStatus) {
        this.subjectStatus = subjectStatus;
    }

    public String getExamRightsQty() {
        return examRightsQty;
    }

    public void setExamRightsQty(String examRightsQty) {
        this.examRightsQty = examRightsQty;
    }

    public List<Irregularity> getIrregularities() {
        return irregularities;
    }

    public void setIrregularities(List<Irregularity> irregularities) {
        this.irregularities = irregularities;
    }

    public List<String> getDisablings() {
        return disablings;
    }

    public void setDisablings(List<String> disablings) {
        this.disablings = disablings;
    }

    public Integer getEfip_dif() {
        return efip_dif;
    }

    public void setEfip_dif(Integer efip_dif) {
        this.efip_dif = efip_dif;
    }

    public AttendanceMode getAttendanceMode() {
        return attendanceMode;
    }

    public void setAttendanceMode(AttendanceMode attendanceMode) {
        this.attendanceMode = attendanceMode;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public StudentRecordMetadataCourseMode getCourseMode() {
        return courseMode;
    }

    public void setCourseMode(StudentRecordMetadataCourseMode courseMode) {
        this.courseMode = courseMode;
    }
}
