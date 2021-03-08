package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = " * [academic-life.student-record](#/academic-life.student-record): If this field is null in the incoming request, it will be populated with default values (_SIN DATOS_)\n" +
        "* [user.contact](#/user.contact): If this field is null in the incoming request, it will be populated with default values (_SIN DATOS_)\n" +
        "* [admission.preenrollment](#/admission.preenrollment): If this field came null from the client that wanted to send the event but locationId was not null, " +
        "then this property is populated with the Location that the " +
        "[Admission API](https://api.ues21.edu.ar/admission-api/api/swagger-ui.html#/default-location-controller/getLocationByIdUsingGET) " +
        "returned")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @ApiModelProperty(value = "location's id", example = "42")
    private Long id;

    @ApiModelProperty(value = "location's name", example = "MALAGUEÑO")
    private String name;

    @ApiModelProperty(value = "location's province")
    private Province province;
}
