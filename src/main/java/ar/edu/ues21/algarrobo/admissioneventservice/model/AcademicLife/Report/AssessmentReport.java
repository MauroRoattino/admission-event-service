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

    @ApiModelProperty(value = "report id", example = "8095212d-fe40-471e-a22f-4d0d2459b0eb")
    private String id;

    @ApiModelProperty(value = "the created statements for the report")
    private List<Statement> statements;

    @ApiModelProperty(value = "start date", example = "2017-05-24 09:52:51+02:00")
    private String startDate;

    @ApiModelProperty(value = "end date", example = "2017-05-24 10:42:11+02:00")
    private String endDate;

    @ApiModelProperty(value = "report grade")
    private String grade;

}


