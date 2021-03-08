package ar.edu.ues21.algarrobo.admissioneventservice.model.kafka;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Enrollment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This is the type of event that will be produced to __Kafka__. " +
        "The name of the topic that this event is produced to is __admission.preenrollment__",
        parent = EventBase.class)
public class EnrollmentEvent extends EventBase {

    @ApiModelProperty(name = "event data")
    private Enrollment data;

    public EnrollmentEvent() {
    }

    public EnrollmentEvent(Enrollment data, String eventType, String source) {
        this.data = data;
        this.setEventType(eventType);
        this.setSource(source);
    }

    public String getEventId() {
        return data.getStudentRecord().getId();
    }

    public Enrollment getData() {
        return data;
    }

    public void setData(Enrollment data) {
        this.data = data;
    }
}
