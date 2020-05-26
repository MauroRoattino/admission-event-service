package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@ApiModel("PeriodApi")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Period {

    private Long id;

    @ApiModelProperty(value = "the period's name", example = "Primer semestre 2019")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "the period's start date", example = "2019-01-03")
    private LocalDate from;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "the period's end date", example = "2019-06-31")
    private LocalDate to;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "the sale's start date of the period", example = "2019-01-03")
    private LocalDate salesFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "the sale's end date of the period", example = "2019-06-31")
    private LocalDate salesTo;

    @ApiModelProperty(value = "the period's subperiods")
    private List<SubPeriod> subperiods;
}