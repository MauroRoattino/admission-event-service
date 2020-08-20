package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicOffer;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.List;

public class PeriodAcademicOffer {
    @ApiModelProperty(name = "id", example = "6331")
    private String id;

    @ApiModelProperty(name = "name", example = "1/20")
    private String name;

    @ApiModelProperty(name = "description", example = "PERIODO DE VENTAS 1/20")
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "from", example = "2020-01-01")
    private LocalDate from;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "to", example = "2020-12-31")
    private LocalDate to;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "salesFrom", example = "2019-09-01")
    private LocalDate salesFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "salesTo", example = "2020-06-01")
    private LocalDate salesTo;

    private List<SubperiodAcademicOffer> subperiods;

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

    public LocalDate getSalesFrom() {
        return salesFrom;
    }

    public void setSalesFrom(LocalDate salesFrom) {
        this.salesFrom = salesFrom;
    }

    public LocalDate getSalesTo() {
        return salesTo;
    }

    public void setSalesTo(LocalDate salesTo) {
        this.salesTo = salesTo;
    }

    public List<SubperiodAcademicOffer> getSubperiods() {
        return subperiods;
    }

    public void setSubperiods(List<SubperiodAcademicOffer> subperiods) {
        this.subperiods = subperiods;
    }
}
