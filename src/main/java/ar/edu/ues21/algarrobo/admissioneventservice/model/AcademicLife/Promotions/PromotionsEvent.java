package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Promotions;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class PromotionsEvent {

    @ApiModelProperty(name = "createdOn", example = "2019/06/31 15:45:10")
    private List<Integer> createdOn;

    @ApiModelProperty(name = "id", example = "0")
    private int id;

    @ApiModelProperty(name = "promotion")
    private Promotion promotion;

    @ApiModelProperty(name = "reason", example = "Descuento adicional congelados")
    private String reason;

    @ApiModelProperty(name = "state", example = "APPROVED")
    private String state;

    @ApiModelProperty(name = "studentRecord", example = "VRIN0011")
    private String studentRecord;

    @ApiModelProperty(name = "updatedBy", example = "user")
    private String updatedBy;

    @ApiModelProperty(name = "updatedOn", example = "2019/06/31 15:50:11")
    private List<Integer> updatedOn;

    @ApiModelProperty(name = "user", example = "SUPERUSUARIO")
    private String user;


    public List<Integer> getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(List<Integer> createdOn) {
        this.createdOn = createdOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStudentRecord() {
        return studentRecord;
    }

    public void setStudentRecord(String studentRecord) {
        this.studentRecord = studentRecord;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<Integer> getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(List<Integer> updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
