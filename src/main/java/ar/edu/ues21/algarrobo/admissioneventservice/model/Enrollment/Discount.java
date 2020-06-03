package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Discount {

    @ApiModelProperty(example = "Refered")
    private String name;

    @ApiModelProperty(example = "1")
    private boolean fixed;

    @ApiModelProperty(example = "30.0")
    private Double percentage;

    @ApiModelProperty(example = "20.0")
    private Double ammount;

    private VTickets parent;
}