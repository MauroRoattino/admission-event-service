package ar.edu.ues21.algarrobo.admissioneventservice.model.User;

import io.swagger.annotations.ApiModelProperty;

public class UserContactRequestId {

    @ApiModelProperty(name = "item", example = "0")
    private Integer item;

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }
}
