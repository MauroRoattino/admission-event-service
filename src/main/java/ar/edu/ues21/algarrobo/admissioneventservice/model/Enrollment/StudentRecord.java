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

    @ApiModelProperty(value = "the StudentRecord's id", example = "ABG01798")
    private String id;

    @ApiModelProperty(example = "555933647047832")
    @JsonIgnore
    private String clientId;

    @ApiModelProperty(example = "2011-08-01T13:17:14")
    private LocalDateTime startDate;

    @ApiModelProperty(example = "2013-11-26T12:10:06")
    private LocalDateTime statusDate;

    @ApiModelProperty(example = "1")
    private Long academicStatus;

    @ApiModelProperty(example = "1")
    private Long accountantStatus;

    @ApiModelProperty(example = "2008-01-30T18:11:29")
    private LocalDateTime academicStatusDate;

    @ApiModelProperty(example = "2008-01-30T18:11:29")
    private LocalDateTime accountantStatusDate;

    private Student student;

    @ApiModelProperty(example = "2")
    private Long status;

    @ApiModelProperty(example = "4")
    private Long sedId;

    private CareerStudyPlan careerStudyPlan;

    @ApiModelProperty(example = "99999")
    private Long admissionCourse;

    @ApiModelProperty(example = "4")
    private Long origenInscripto;

    @ApiModelProperty(example = "1")
    private Long enrollmentPaid;

    @ApiModelProperty(example = "1")
    private Long inscriptionId;

    @ApiModelProperty(example = "3")
    private Long siteId;

    private ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.persistence.Period initialPeriod;

    @ApiModelProperty(example = "OLIOTTA")
    private String usrPortal;

    private CourseModeZoneSede courseModeZoneSede;

    @ApiModelProperty(example = "3")
    private Long siteRefId;

    @ApiModelProperty(example = "C")
    private String idLms;

    private AttendanceMode attendanceMode;

    @ApiModelProperty(example = "0")
    private Integer future;

    @ApiModelProperty(value = "student referrer state")
    private RefState refState;

    public static class RefState {
        @ApiModelProperty(example = "1")
        Boolean refAvailable;
        @ApiModelProperty(example = "Habilitado")
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
