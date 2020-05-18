package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@ApiModel("StudyClass")
@Entity
@Table(name = "V_UE_CLASE_ESTUDIO", schema = "UE21")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"level"})
public class StudyClass {

    @ApiModelProperty(value = "the StudyClass's id")
    @Id
    private Long id;

    @ApiModelProperty(value = "the StudyClass's name")
    @Column(name = "NOMBRE")
    private String name;

    @ApiModelProperty(value = "the StudyClass's code")
    @Column(name = "CODIGO")
    private String code;

    @ApiModelProperty(value = "the StudyClass's state", example = "ACTIVE")
    @Enumerated
    @Column(name = "HABILITADA")
    private State state;

    @ManyToMany
    @JoinTable(name = "UE_MODALIDAD_TIPO_CARRERAS",
        joinColumns = @JoinColumn(name = "ID_TIPO_CARRERA"),
        inverseJoinColumns = @JoinColumn(name = "ID_MODALIDAD")
    )
    private List<AttendanceMode> attendanceModes;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public State getState() {
        return state;
    }

    public void setState(final State state) {
        this.state = state;
    }

    public List<AttendanceMode> getAttendanceModes() {
        return attendanceModes;
    }

    public void setAttendanceModes(final List<AttendanceMode> attendanceModes) {
        this.attendanceModes = attendanceModes;
    }

    @Override
    public String toString() {
        return "StudyClass{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", code='" + code + '\'' +
            ", state=" + state +
            ", attendanceModes=" + attendanceModes +
            '}';
    }

    /**
     * StudyClass state
     */
    public enum State {
        UNKNOWN, ACTIVE, INACTIVE;
    }

    public boolean isEDN(Long studyClassId) {
        var ednIds = Lists.newArrayList(10L, 13L, 15L, 17L, 18L, 19L, 45L);
        return ednIds.contains(studyClassId);
    }
}
