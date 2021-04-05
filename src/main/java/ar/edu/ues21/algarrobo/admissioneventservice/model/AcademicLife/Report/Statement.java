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
public class Statement {

    @ApiModelProperty(value = "statement id")
    private String id;

    @ApiModelProperty(value = "statement description")
    private String description;

    @ApiModelProperty(value = "statement answers")
    private List<Answer> answers;

    @ApiModelProperty(value = "selected answers")
    private List<String> selectedAnswers;

    @ApiModelProperty(value = "review")
    private String review;

}
