package ar.edu.ues21.algarrobo.admissioneventservice.model.Cau;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class Cau {
    @ApiModelProperty(name = "id", example = "C1002")
    private String id;

    @ApiModelProperty(name = "id", example = "ASOCIACIÓN DE ESTUDIOS SUPERIORES RÍO QUEQUÉN")
    private String name;

    @ApiModelProperty(name = "code", example = "NEC01")
    private String code;

    @ApiModelProperty(name = "type", example = "CAU")
    private String type;

    @ApiModelProperty(name = "locationid", example = "5423")
    private String locationid;

    @ApiModelProperty(name = "location", example = "NECOCHEA")
    private String location;

    @ApiModelProperty(name = "province", example = "BUENOS AIRES")
    private String province;

    @ApiModelProperty(name = "country", example = "ARGENTINA")
    private String country;

    @ApiModelProperty(name = "postalCode", example = "C1052")
    private String postalCode;

    @ApiModelProperty(name = "state", example = "ACTIVE")
    private String state;

    @ApiModelProperty(name = "email", example = "aaa@hh.com")
    private String email;

    @ApiModelProperty(name = "mobilephone", example = "54654645")
    private String mobilephone;

    @ApiModelProperty(name = "facebook", example = "facebook url or id")
    private String facebook;

    @ApiModelProperty(name = "instagram", example = "instagram url or id")
    private String instagram;

    @ApiModelProperty(name = "linkedin", example = "linkedin url or id")
    private String linkedin;

    @ApiModelProperty(name = "twitter", example = "twitter url or id")
    private String twitter;

    @ApiModelProperty(name = "skype", example = "skype url or id")
    private String skype;

    @ApiModelProperty(name = "referencialPrice", example = "5555.56")
    private String referencialPrice;

    @ApiModelProperty(name = "website", example = "www.cau.com.ar")
    private String website;

    private List<Location> nearLocations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getReferencialPrice() {
        return referencialPrice;
    }

    public void setReferencialPrice(String referencialPrice) {
        this.referencialPrice = referencialPrice;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Location> getNearLocations() {
        return nearLocations;
    }

    public void setNearLocations(List<Location> nearLocations) {
        this.nearLocations = nearLocations;
    }
}
