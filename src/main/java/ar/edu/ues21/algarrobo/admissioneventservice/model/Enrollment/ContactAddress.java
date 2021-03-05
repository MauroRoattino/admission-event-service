package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("ContactAddress")
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    
    @ApiModelProperty(example = "Cordoba,Cordoba,Argentina",
            value = "If this field came null from the client that wanted to send the event but locationId was not null, " +
                    "then this property is populated with the Location that the " +
                    "[Admission API](https://api.ues21.edu.ar/admission-api/api/swagger-ui.html#/default-location-controller/getLocationByIdUsingGET) " +
                    "returned")
    private Location locationRef;

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

    public Location getLocationRef() {
        return this.locationRef;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getTower() {
        return tower;
    }

    public void setTower(String tower) {
        this.tower = tower;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Long getNeighborhoodId() {
        return neighborhoodId;
    }

    public void setNeighborhoodId(Long neighborhoodId) {
        this.neighborhoodId = neighborhoodId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLocationRef(Location locationRef) {
        this.locationRef = locationRef;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
