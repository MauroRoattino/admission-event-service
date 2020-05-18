package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@ApiModel("PeriodApi")
@Entity
@Table(name = "V_UE_PERIODO", schema = "UE21")
public class Period {

    @Id
    private Long id;

    @ApiModelProperty(value = "the period's name", example = "Primer semestre 2019")
    @Column(name = "CODIGO")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "the period's start date", example = "2019-01-03")
    @Column(name = "CURSADO_INICIO")
    private LocalDate from;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "the period's end date", example = "2019-06-31")
    @Column(name = "CURSADO_FINAL")
    private LocalDate to;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "the sale's start date of the period", example = "2019-01-03")
    @Column(name = "VENTAS_INICIO")
    private LocalDate salesFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "the sale's end date of the period", example = "2019-06-31")
    @Column(name = "VENTAS_FINAL")
    private LocalDate salesTo;

    @ApiModelProperty(value = "the period's subperiods")
    @OneToMany(mappedBy = "period")
    private List<SubPeriod> subperiods;

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

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(final LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(final LocalDate to) {
        this.to = to;
    }

    public LocalDate getSalesFrom() {
        return salesFrom;
    }

    public void setSalesFrom(final LocalDate salesFrom) {
        this.salesFrom = salesFrom;
    }

    public LocalDate getSalesTo() {
        return salesTo;
    }

    public void setSalesTo(final LocalDate salesTo) {
        this.salesTo = salesTo;
    }

    public List<SubPeriod> getSubperiods() {
        return this.subperiods;
    }

    public void setSubperiods(List<SubPeriod> subperiods) {
        this.subperiods = subperiods;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", from='" + getFrom() + "'" + ", to='"
                + getTo() + "'" + ", salesFrom='" + getSalesFrom() + "'" + ", salesTo='" + getSalesTo() + "'"
                + ", subperiods='" + getSubperiods() + "'" + "}";
    }
}