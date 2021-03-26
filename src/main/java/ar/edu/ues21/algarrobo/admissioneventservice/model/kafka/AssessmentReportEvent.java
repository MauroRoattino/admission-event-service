package ar.edu.ues21.algarrobo.admissioneventservice.model.kafka;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Report.AssessmentReport;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This is the type of event that will be produced to __Kafka__. " +
        "The name of the topic that this event is produced to is __assessment.report__",
        parent = EventBase.class)
public class AssessmentReportEvent extends EventBase {

    @ApiModelProperty(name = "event data")
    private AssessmentReport data;

    public AssessmentReportEvent(AssessmentReport data, String eventType, String eventSource) {
        this.data = data;
        this.setEventType(eventType);
        this.setSource(eventSource);
    }

    @Override
    public String getEventId() {
        return data.getId();
    }

    public AssessmentReport getData() {
        return data;
    }

    public void setData(AssessmentReport data) {
        this.data = data;
    }
}
