package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicOffer;

public class AcademicOffer {
    private PeriodAcademicOffer period;

    private CareerAcademicOffer career;

    private CauAcademicOffer cau;

    private AttendanceModeAcademicOffer attendanceMode;

    private CourseModeAcademicOffer courseMode;

    public PeriodAcademicOffer getPeriod() {
        return period;
    }

    public void setPeriod(PeriodAcademicOffer period) {
        this.period = period;
    }

    public CareerAcademicOffer getCareer() {
        return career;
    }

    public void setCareer(CareerAcademicOffer career) {
        this.career = career;
    }

    public CauAcademicOffer getCau() {
        return cau;
    }

    public void setCau(CauAcademicOffer cau) {
        this.cau = cau;
    }

    public AttendanceModeAcademicOffer getAttendanceMode() {
        return attendanceMode;
    }

    public void setAttendanceMode(AttendanceModeAcademicOffer attendanceMode) {
        this.attendanceMode = attendanceMode;
    }

    public CourseModeAcademicOffer getCourseMode() {
        return courseMode;
    }

    public void setCourseMode(CourseModeAcademicOffer courseMode) {
        this.courseMode = courseMode;
    }
}
