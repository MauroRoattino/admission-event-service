package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("StudentRecord")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRecord {

    @ApiModelProperty(value = "the StudentRecord's id")
    private String id;

    @JsonIgnore
    private String clientId;

    private LocalDateTime startDate;

    private LocalDateTime statusDate;

    private Long academicStatus;

    private Long accountantStatus;

    private LocalDateTime academicStatusDate;

    private LocalDateTime accountantStatusDate;

    private Student student;

    private Long status;

    private Long sedId;

    private CareerStudyPlan careerStudyPlan;

    private Long admissionCourse;

    private Long origenInscripto;

    private Long enrollmentPaid;

    private Long inscriptionId;

    private Long siteId;

    private ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.persistence.Period initialPeriod;

    private String usrPortal;

    private CourseModeZoneSede courseModeZoneSede;

    private Long siteRefId;

    private String idLms;

    private AttendanceMode attendanceMode;

    private Integer future;

    @ApiModelProperty(value = "student referrer state")
    private RefState refState;

    public static class RefState {
        Boolean refAvailable;
        String refMsg;

        public Boolean getRefAvailable() {
            return refAvailable;
        }

        public void setRefAvailable(Boolean refAvailable) {
            this.refAvailable = refAvailable;
        }

        public String getRefMsg() {
            return refMsg;
        }

        public void setRefMsg(String refMsg) {
            this.refMsg = refMsg;
        }

    }

    public enum RefMsg {
        H("Habilitado"),
        MNV("No posee matrícula vigente"),
        MNA("No posee matrícula activa"),
        COUNT("Superó la cantidad permitida de referencias"),
        DIFSC("Pertenece a una modalidad diferente al aspirante");

        RefMsg(String v) {
            this.value = v;
        }

        private final String value;

        public String getValue() {
            return value;
        }
    }
}
