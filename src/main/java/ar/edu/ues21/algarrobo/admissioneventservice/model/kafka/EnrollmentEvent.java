package ar.edu.ues21.algarrobo.admissioneventservice.model.kafka;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Enrollment;
import io.swagger.annotations.ApiModelProperty;

public class EnrollmentEvent extends EventBase {

    @ApiModelProperty(name = "event data")
    private Enrollment data;

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
