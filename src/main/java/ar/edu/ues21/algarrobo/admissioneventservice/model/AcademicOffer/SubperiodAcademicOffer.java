package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicOffer;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.List;

public class SubperiodAcademicOffer {
    @ApiModelProperty(name = "id", example = "7053")
    private String id;

    @ApiModelProperty(name = "name", example = "01/20")
    private String name;

    @ApiModelProperty(name = "description", example = "PERIODO 1/20 VERANO")
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "from", example = "2020-01-01")
    private LocalDate from;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "to", example = "2020-03-31")
    private LocalDate to;

    @ApiModelProperty(name = "subPeriod", example = "A")
    private String subPeriod;

    @ApiModelProperty(name = "enrollment", example = "N")
    private String enrollment;

    @ApiModelProperty(name = "kind", example = "1")
    private Integer kind;

    @ApiModelProperty(name = "attendanceModes", example = "[1,2,5,7,8,10]")
    private List<Integer> attendanceModes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public String getSubPeriod() {
        return subPeriod;
    }

    public void setSubPeriod(String subPeriod) {
        this.subPeriod = subPeriod;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    public List<Integer> getAttendanceModes() {
        return attendanceModes;
    }

    public void setAttendanceModes(List<Integer> attendanceModes) {
        this.attendanceModes = attendanceModes;
    }
}
