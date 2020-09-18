package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@ApiModel("Period")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Period {

    private Long id;
    
    @ApiModelProperty(value = "the period's name", example = "Primer semestre 2019")
    private String code;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING)    
    @ApiModelProperty(value = "the period's start date", example = "2019-01-03")
    private LocalDate from;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(value = "the period's end date", example = "2019-06-30")
    private LocalDate to;
    
    @ApiModelProperty(value = "the period's name", example = "1/19 A")
    private String subPeriod;

    @ApiModelProperty(value = "the period's name", example = "1")
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