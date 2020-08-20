package ar.edu.ues21.algarrobo.admissioneventservice.model.User;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Country;
import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.CourseMode;
import ar.edu.ues21.algarrobo.admissioneventservice.model.User.Career.UserCareer;

public class UserContactRequest {
    private String attendanceMode;
    private UserCareer career;
    private Country country;
    private CourseMode courseMode;
    private UserContactRequestId id;
    private Integer preEnrollmentCrm;
    private String requestDate;
    private Integer status;
    private String statusDate;
    private String usrPortal;

    public String getAttendanceMode() {
        return attendanceMode;
    }

    public void setAttendanceMode(String attendanceMode) {
        this.attendanceMode = attendanceMode;
    }

    public UserCareer getCareer() {
        return career;
    }

    public void setCareer(UserCareer career) {
        this.career = career;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public CourseMode getCourseMode() {
        return courseMode;
    }

    public void setCourseMode(CourseMode courseMode) {
        this.courseMode = courseMode;
    }

    public UserContactRequestId getId() {
        return id;
    }

    public void setId(UserContactRequestId id) {
        this.id = id;
    }

    public Integer getPreEnrollmentCrm() {
        return preEnrollmentCrm;
    }

    public void setPreEnrollmentCrm(Integer preEnrollmentCrm) {
        this.preEnrollmentCrm = preEnrollmentCrm;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getUsrPortal() {
        return usrPortal;
    }

    public void setUsrPortal(String usrPortal) {
        this.usrPortal = usrPortal;
    }
}
