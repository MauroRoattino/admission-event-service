package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("Countries")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {

  @ApiModelProperty(value = "country's id", example = "4")
  private Long id;

  @ApiModelProperty(value = "country's name", example = "ARGENTINA")
  private String name;

  @ApiModelProperty(value = "country's nationality", example = "ARGENTINA")
  private String nationality;
}
