package ar.edu.ues21.algarrobo.admissioneventservice.model;

import ar.edu.ues21.algarrobo.admissioneventservice.model.User.UserContact;
import io.swagger.annotations.ApiModelProperty;

public class UserContactEvent extends EventBase {

    @ApiModelProperty(name = "event data")
    private UserContact data;

    public UserContactEvent(UserContact data, String eventType, String source) {
        this.data = data;
        this.setSource(source);
        this.setEventType(eventType);
    }

    public UserContact getData() {
        return data;
    }

    public void setData(UserContact data) {
        this.data = data;
    }
}
