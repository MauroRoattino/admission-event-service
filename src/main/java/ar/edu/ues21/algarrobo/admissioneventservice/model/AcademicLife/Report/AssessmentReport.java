package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Report;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentReport {

    @ApiModelProperty(value = "report id")
    private String id;

    @ApiModelProperty(value = "the created statements for the report")
    private List<Statement> statements;

    @ApiModelProperty(value = "start date")
    private String startDate;

    @ApiModelProperty(value = "end date")
    private String endDate;

    @ApiModelProperty(value = "report grade")
    private String grade;

}


