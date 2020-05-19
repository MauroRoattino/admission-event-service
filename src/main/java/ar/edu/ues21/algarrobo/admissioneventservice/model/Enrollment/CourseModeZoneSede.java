package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class that represents the course mode zone for the sede
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseModeZoneSede {

    private Long id;

    private Long sedeId;

    private Long zoneId;

    private CourseMode courseMode;

    private Long zone;

    private Long status;
}
