package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("Provinces")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Province{

    @ApiModelProperty(value = "province's id", example = "1")
    private Long id;

    @ApiModelProperty(value = "province's name", example = "CORDOBA")
    private String name;

    @ApiModelProperty(value = "province's country", example = "ARGENTINA")
    private Country country;
}
