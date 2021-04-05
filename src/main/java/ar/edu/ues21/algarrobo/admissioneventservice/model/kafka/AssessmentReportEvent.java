package ar.edu.ues21.algarrobo.admissioneventservice.model.kafka;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.Report.AssessmentReport;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This is the type of event that will be produced to __Kafka__. " +
        "The name of the topic that this event is produced to is __assessment.report__",
        parent = EventBase.class)
public class AssessmentReportEvent extends EventBase {

    @ApiModelProperty(name = "event data")
    private AssessmentReport assessmentReport;

    public AssessmentReportEvent(AssessmentReport assessmentReport, String eventType, String eventSource) {
        this.assessmentReport = assessmentReport;
        this.setEventType(eventType);
        this.setSource(eventSource);
    }

    @Override
    public String getEventId() {
        return assessmentReport.getId();
    }

    public AssessmentReport getAssessmentReport() {
        return assessmentReport;
    }

    public void setAssessmentReport(AssessmentReport assessmentReport) {
        this.assessmentReport = assessmentReport;
    }
}
