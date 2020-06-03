package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("ContactAddress")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class ContactAddress {

    @ApiModelProperty(value = "id", example = "1341178")
    private Long id;

    @ApiModelProperty(value = "type", example = "2")
    private Long type;

    @ApiModelProperty(value = "street", example = "Raymundo Montenegro")
    private String street;

    @ApiModelProperty(value = "streetId", example = "21246")
    private Long streetId;

    @ApiModelProperty(value = "number", example = "2678")
    private String number;

    @ApiModelProperty(value = "floor", example = "1")
    private String floor;

    @ApiModelProperty(value = "apartment", example = "a")
    private String apartment;

    @ApiModelProperty(value = "tower", example = "b")
    private String tower;

    @ApiModelProperty(value = "neighborhood", example = "Sachi")
    private String neighborhood;

    @ApiModelProperty(value = "neighborhoodId", example = "21234")
    private Long neighborhoodId;

    @ApiModelProperty(value = "location", example = "Cordoba")
    private String location;

    @ApiModelProperty(value = "locationId", example = "232")
    private Long locationId;

    @ApiModelProperty(value = "postalCode", example = "5002")
    private String postalCode;

    @ApiModelProperty(value = "primaryPhone", example = "115484631")
    private String primaryPhone;

    @ApiModelProperty(value = "secondaryPhone", example = "654847")
    private String secondaryPhone;

    @ApiModelProperty(value = "fax", example = "-")
    private String fax;

    @ApiModelProperty(value = "details", example = "-")
    private String details;
}
