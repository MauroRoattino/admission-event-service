package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@ApiModel("Period")
@Entity
@Table(name ="ue_turnos_cursado", schema = "ue21")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Period implements Serializable {
    
    private static final long serialVersionUID = -9009773048932121855L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ApiModelProperty(value = "the period's name", example = "Primer semestre 2019")
    @Column(name = "CODIGO")
    private String code;
    
    @ApiModelProperty(value = "the period's start date", example = "2019-01-03")
    @Column(name = "CURSADO_INICIO")
    private LocalDate from;
    
    @ApiModelProperty(value = "the period's end date", example = "2019-06-31")
    @Column(name = "CURSADO_FINAL")
    private LocalDate to;
    
    @ApiModelProperty(value = "the period's name", example = "1/19 A")
    @Column(name = "SUBPERIODO")
    private String subPeriod;

    @ApiModelProperty(value = "the period's name", example = "1/19 A")
    @Column(name = "TIPO_CURSADO")
    private Integer tipo;

    @JsonIgnore
    public boolean isSummer() {
        return code != null && code.startsWith("0");
    }

    @JsonIgnore
    public boolean isSubPeriodA() {
        return ! isSummer() && "A".equalsIgnoreCase(subPeriod);
    }

    @JsonIgnore
    public boolean isSubPeriodB() {
        return ! isSummer() && "B".equalsIgnoreCase(subPeriod);
    }



}