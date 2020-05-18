package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel("AttendanceMode")
@Entity
@Table(name = "V_UE_TIPO_MODALIDAD", schema = "UE21")
@JsonIgnoreProperties({"group"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceMode {

    @ApiModelProperty(value = "the AttendanceMode's id")
    @Id
    private Long id;

    @ApiModelProperty(value = "the AttendanceMode's code", example = "1")
    @Column(name = "CODIGO")
    private String code;

    @ApiModelProperty(value = "the AttendanceMode's name", example = "Distancia - ED HOME")
    @Column(name = "NOMBRE")
    private String name;


    @ApiModelProperty(value = "the AttendanceMode's grouo", example = "D")
    @Column(name = "MODALIDAD")
    private String group;

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
        return "AttendanceMode{" +
            "id=" + id +
            ", code='" + code + '\'' +
            ", name='" + name + '\'' +
            '}';
    }
}
