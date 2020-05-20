package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "period" })
public class SubPeriod {

    private Long id;

    @ApiModelProperty(value = "the subperiod's period")
    private Period period;

    @ApiModelProperty(value = "the subperiod's name", example = "Primer semestre 2019")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "the subperiod's start date", example = "2019-01-03")
    private LocalDate from;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "the subperiod's end date", example = "2019-06-31")
    private LocalDate to;

    @ApiModelProperty(value = "the subperiod's description", example = "Periodo 1/19 A -- MARZO - MAYO")
    private String description;

    @ApiModelProperty(value = "the subperiod's type", example = "A")
    private String subperiod;

    @ApiModelProperty(value = "the subperiod's enrollment flag", example = "S")
    private String enrollment;

    @ApiModelProperty(value = "Subperiod type, a.k.a tipo_cursado", example = "2")
    private Long type;
    
    @JsonIgnore
    public Boolean isA() {
    	if (this.getSubperiod() != null)
    	return this.getSubperiod().equalsIgnoreCase("A");
    	else
    	return false;	
    }
}