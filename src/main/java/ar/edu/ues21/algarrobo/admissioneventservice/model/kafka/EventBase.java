package ar.edu.ues21.algarrobo.admissioneventservice.model.kafka;

import io.swagger.annotations.ApiModelProperty;

public abstract class EventBase implements EventBaseInterface {
    @ApiModelProperty(name = "event type", example = "admission-event")
    private String eventType;

    @ApiModelProperty(name = "source")
    private String source;

    public EventBase() {
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
