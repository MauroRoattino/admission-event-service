package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "V_UE_SUBPERIODO", schema = "UE21")
@JsonIgnoreProperties({ "period" })
public class SubPeriod {

    @Id
    private Long id;

    @ApiModelProperty(value = "the subperiod's period")
    @ManyToOne()
    @JoinColumn(name = "PERIODO")
    private Period period;

    @ApiModelProperty(value = "the subperiod's name", example = "Primer semestre 2019")
    @Column(name = "CODIGO")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "the subperiod's start date", example = "2019-01-03")
    @Column(name = "CURSADO_INICIO")
    private LocalDate from;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "the subperiod's end date", example = "2019-06-31")
    @Column(name = "CURSADO_FINAL")
    private LocalDate to;

    @ApiModelProperty(value = "the subperiod's description", example = "Periodo 1/19 A -- MARZO - MAYO")
    @Column(name = "DESCRIPCION")
    private String description;

    @ApiModelProperty(value = "the subperiod's type", example = "A")
    @Column(name = "SUBPERIODO")
    private String subperiod;

    @ApiModelProperty(value = "the subperiod's enrollment flag", example = "S")
    @Column(name = "INGRESANTES")
    private String enrollment;

    @ApiModelProperty(value = "Subperiod type, a.k.a tipo_cursado", example = "S")
    @Column(name = "TIPO_CURSADO")
    private Long type;



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Period getPeriod() {
        return this.period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFrom() {
        return this.from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return this.to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubperiod() {
        return this.subperiod;
    }

    public void setSubperiod(String subperiod) {
        this.subperiod = subperiod;
    }

    public String getEnrollment() {
        return this.enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }
    
    @JsonIgnore
    public Boolean isA() {
    	if (this.getSubperiod() != null)
    	return this.getSubperiod().equalsIgnoreCase("A");
    	else
    	return false;	
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}