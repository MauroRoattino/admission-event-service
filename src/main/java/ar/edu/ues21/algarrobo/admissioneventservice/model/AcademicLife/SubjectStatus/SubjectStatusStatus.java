package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.SubjectStatus;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Status.Flag;

public class SubjectStatusStatus {
    @ApiModelProperty(name = "id", example = "0")
    private Long id;

    @ApiModelProperty(name = "description", example = "PENDIENTES")
    private String description;

    @ApiModelProperty(name = "date", example = "null")
    private String date;

    @ApiModelProperty(name = "reason", example = "")
    private String reason;

    private SubjectStatusGroup group;

    private List<Flag> flags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public SubjectStatusGroup getGroup() {
        return group;
    }

    public void setGroup(SubjectStatusGroup group) {
        this.group = group;
    }

    public List<Flag> getFlags() {
        return flags;
    }

    public void setFlags(List<Flag> flags) {
        this.flags = flags;
    }
}
