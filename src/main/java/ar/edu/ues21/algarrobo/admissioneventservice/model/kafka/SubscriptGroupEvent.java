package ar.edu.ues21.algarrobo.admissioneventservice.model.kafka;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.SubscriptGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This is the type of event that will be produced to __Kafka__. " +
        "The name of the topic that this event is produced to is __assessment.subscriptGroup__",
        parent = EventBase.class)
public class SubscriptGroupEvent extends EventBase{

    @ApiModelProperty(name = "event data")
    private SubscriptGroup subscriptGroup;

    public SubscriptGroupEvent(SubscriptGroup subscriptGroup, String eventType, String eventSource) {
        this.subscriptGroup = subscriptGroup;
        this.setEventType(eventType);
        this.setSource(eventSource);
    }

    @Override
    public String getEventId() {
        return subscriptGroup.getExternalId();
    }

    public SubscriptGroup getSubscriptGroup() {
        return subscriptGroup;
    }

    public void setSubscriptGroup(SubscriptGroup subscriptGroup) {
        this.subscriptGroup = subscriptGroup;
    }
}
