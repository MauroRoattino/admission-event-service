package ar.edu.ues21.algarrobo.admissioneventservice.model.kafka;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.AcademicLifeStudentRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This is the type of event that will be produced to __Kafka__. " +
        "The name of the topic that this event is produced to is __academic-life.student-record__",
        parent = EventBase.class)
public class StudentRecordEvent extends EventBase {

    @ApiModelProperty(name = "event data")
    private AcademicLifeStudentRecord data;

    public StudentRecordEvent() {
    }

    public StudentRecordEvent(AcademicLifeStudentRecord data, String eventType, String source) {
        this.data = data;
        this.setEventType(eventType);
        this.setSource(source);
    }

    public String getEventId() {
        return data.getId();
    }

    public AcademicLifeStudentRecord getData() {
        return data;
    }

    public void setData(AcademicLifeStudentRecord data) {
        this.data = data;
    }
}
