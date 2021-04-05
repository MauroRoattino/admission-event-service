package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Report;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @ApiModelProperty(value = "answer id")
    private String id;

    @ApiModelProperty(value = "answer description")
    private String description;

    @ApiModelProperty(value = "mark if the answer is correct")
    private Boolean isCorrect;

}
