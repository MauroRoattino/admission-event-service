package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel("CourseMode")
@Entity
@Table(name = "V_UE_TURNO_CURSADO", schema = "UE21")
public class CourseMode {

    @ApiModelProperty(value = "the CourseMode's id")
    @Id
    private Long id;

    @ApiModelProperty(value = "the CourseMode's code", example = "1")
    @Column(name = "CODIGO")
    private String code;

    @ApiModelProperty(value = "the CourseMode's name", example = "Mañana")
    @Column(name = "NOMBRE")
    private String name;

    /**
     * Creates a new instance of {@link CourseMode}
     */
    public CourseMode() {
    }

    /**
     * Creates a new instance of {@link CourseMode}
     *
     * @param id   the {@link CourseMode} identifier
     * @param code the {@link CourseMode}'s code
     * @param name the {@link CourseMode}'s name
     */
    public CourseMode(final Long id, final String code, final String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CourseMode{" +
            "id=" + id +
            ", code='" + code + '\'' +
            ", name='" + name + '\'' +
            '}';
    }
}
