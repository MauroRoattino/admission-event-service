package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@ApiModel("ContactAddress")
@Entity
@Table(name = "UE_DOMICILIOS", schema = "UE21")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UE_DOMICILIOS_SEQ")
    @SequenceGenerator(name = "UE_DOMICILIOS_SEQ", sequenceName = "UE_DOMICILIOS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "TIPO_DOMICILIO")
    private Long type;

    @Column(name = "CALLE")
    private String street;

    @Column(name = "CAL_ID")
    private Long streetId;

    @Column(name = "NRO")
    private String number;

    @Column(name = "PISO")
    private String floor;

    @Column(name = "DPTO")
    private String apartment;

    @Column(name = "TORRE")
    private String tower;

    @Column(name = "BARRIO")
    private String neighborhood;

    @Column(name = "BAR_ID")
    private Long neighborhoodId;

    @Column(name = "LOCALIDAD")
    private String location;

    @Column(name = "LOC_ID")
    private Long locationId;

    @Column(name = "CP")
    private String postalCode;

    @Column(name = "TELEFONO1")
    private String primaryPhone;

    @Column(name = "TELEFONO2")
    private String secondaryPhone;

    @Column(name = "FAX")
    private String fax;

    @Column(name = "OBSERVACIONES")
    private String details;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getType() {
        return type;
    }

    public void setType(final Long type) {
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String streetname) {
        this.street = streetname;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(final Long streetId) {
        this.streetId = streetId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(final String floor) {
        this.floor = floor;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(final String apartment) {
        this.apartment = apartment;
    }

    public String getTower() {
        return tower;
    }

    public void setTower(final String tower) {
        this.tower = tower;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(final String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Long getNeighborhoodId() {
        return neighborhoodId;
    }

    public void setNeighborhoodId(final Long neighborhoodId) {
        this.neighborhoodId = neighborhoodId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public Long getLocationId() {
        return this.locationId;
    }

    public void setLocationId(final Long locationId) {
        this.locationId = locationId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(final String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(final String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(final String fax) {
        this.fax = fax;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(final String details) {
        this.details = details;
    }
}
