package ar.edu.ues21.algarrobo.admissioneventservice.model.kafka;

import ar.edu.ues21.algarrobo.admissioneventservice.model.User.UserData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This is the type of event that will be produced to __Kafka__. " +
        "The name of the topic that this event is produced to is __user.contact__",
        parent = EventBase.class)
public class UserContactEvent extends EventBase {

    @ApiModelProperty(name = "event data")
    private UserData data;

    public UserContactEvent() {
    }

    public UserContactEvent(UserData data, String eventType, String source) {
        this.data = data;
        this.setSource(source);
        this.setEventType(eventType);
    }

    public String getEventId() {
        return data.getId().toString();
    }

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }
}
