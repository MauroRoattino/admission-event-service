package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife;

import com.fasterxml.jackson.annotation.JsonFormat;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Status.Flag;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.List;

public class AcademicStatus {
    @ApiModelProperty(name = "id", example = "1")
    private Long id;

    @ApiModelProperty(name = "description", example = "")
    private String description;

    @ApiModelProperty(value = "date", example = "2012-09-18 00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;

    @ApiModelProperty(name = "reason", example = "")
    private String reason;

    @ApiModelProperty(name = "group", example = "null")
    private String group;

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Flag> getFlags() {
        return flags;
    }

    public void setFlags(List<Flag> flags) {
        this.flags = flags;
    }
}
