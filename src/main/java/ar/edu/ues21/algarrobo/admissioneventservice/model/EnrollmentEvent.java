package ar.edu.ues21.algarrobo.admissioneventservice.model;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Enrollment;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EnrollmentEvent {

    @ApiModelProperty(name = "event type", example = "admission-event")
    private String eventType;

    @ApiModelProperty(name = "event data")
    private Enrollment data;
}
