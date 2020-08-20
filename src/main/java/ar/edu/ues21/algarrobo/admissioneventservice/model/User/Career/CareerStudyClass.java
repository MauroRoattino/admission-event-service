package ar.edu.ues21.algarrobo.admissioneventservice.model.User.Career;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.AttendanceMode;

public class CareerStudyClass {
    private List<AttendanceMode> attendanceModes;

    private String code;

    private Long id;

    private String name;

    @ApiModelProperty(name = "id", example = "ACTIVE")
    private String state;

    public List<AttendanceMode> getAttendanceModes() {
        return attendanceModes;
    }

    public void setAttendanceModes(List<AttendanceMode> attendanceModes) {
        this.attendanceModes = attendanceModes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
