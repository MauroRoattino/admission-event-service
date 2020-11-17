package ar.edu.ues21.algarrobo.admissioneventservice.model.kafka;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.AcademicLifeStudentRecord;
import io.swagger.annotations.ApiModelProperty;

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