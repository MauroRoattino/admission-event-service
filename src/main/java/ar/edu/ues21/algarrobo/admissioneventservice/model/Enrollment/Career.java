package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.exception.NotFoundException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("Career")
@Entity
@Table(name = "UE_CARRERAS", schema = "UE21")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"level", "edn"})
public class Career implements Serializable {

    private static final long serialVersionUID = 6292077892803874492L;

    @ApiModelProperty(value = "the career's id")
    @Id
    private Long id;

    @ApiModelProperty(value = "the career's name")
    @Column(name = "DESCRIPCION")
    private String name;

    @ApiModelProperty(value = "the career's code")
    @Column(name = "DESCRIPCION_CORTA")
    private String code;

    @JoinColumn(name = "CAR_ID")
    @OneToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.ALL
        })
    private List<CareerStudyPlan> plans;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }


    /**
     *  Educación y escribanía, son de grado y generar tkt pregrado
     * Educación: 1659 
     * Escribanía: 1657
     * 
     * Procurador es de pregrado y generan de grado con sus propios aranceles;
     * Procurador: 1861
     */

    private static final Long VEDU = Long.valueOf(1659);
    private static final Long VESC = Long.valueOf(1657);
    private static final Long PROC = Long.valueOf(1861);
    private static final Long TAGT = Long.valueOf(1863);
    private static final Long DGEM = Long.valueOf(647);
    private static final Long DGEB = Long.valueOf(3002);

    private static final Map<Long, Level> leveExceptions;

    static {
        leveExceptions = new HashMap<>();
        leveExceptions.put(VEDU, Level.UNDERGRADUATE);
        leveExceptions.put(VESC, Level.UNDERGRADUATE);   
        leveExceptions.put(TAGT, Level.UNDERGRADUATE);   
        leveExceptions.put(PROC, Level.UNDERGRADUATE_PROCURATOR);
        leveExceptions.put(DGEM, Level.EDN_THREE_SEMESTER);
        leveExceptions.put(DGEB, Level.EDN_THREE_SEMESTER);
    }

  

    /**
     * Returns PREGRADO_PROCURADOR when career is Procurador (id 1861). GRADO when alt least one study class is 1 or 4.
     * if the study class is 11 returns PREGRADO
     * otherwise returns the optional EMPTY.
     *
     * @return
     */
    public Level getLevel() {
        // TODO Renombrar como modo facturación!!!
        // 1 grado, 4 grado presencial, 11 pregrado, 20 grado X
        // 10 EXTRAGRADO, 13 MAESTRIAS, 15 CURSOS EVENTOS Y WORKS,
        // 17 DIPLOMADOS CLOUD 21, 18 CERTIFICADOS CLOUD 21, 19 CURSOS CLOUD 21, 45 MAESTRIA VIRTUAL

        if (leveExceptions.containsKey(this.getId())) {
            return leveExceptions.get(this.getId());
        }

        var validLevels = Lists.newArrayList("1", "4", "7", "11", "20", "10", "13", "15", "17", "18", "19", "45");

        return this.plans.stream().filter(s -> s.getEnabled() == 1 && validLevels.contains(s.getId().getStudyClass().getCode())).map(s -> {
            if (s.getId().getStudyClass().getCode().equals("1") || s.getId().getStudyClass().getCode().contentEquals("4")
                || s.getId().getStudyClass().getCode().contentEquals("20") || s.getId().getStudyClass().getCode().contentEquals("7")) {
                return Level.DEGREE;
            } else if (s.getId().getStudyClass().getCode().contentEquals("17") ||
                    s.getId().getStudyClass().getCode().contentEquals("18") ||
                    s.getId().getStudyClass().getCode().contentEquals("19")) {
                return Level.EDN_SEMESTER;
            } else if (s.getId().getStudyClass().getCode().contentEquals("10") ||
                    s.getId().getStudyClass().getCode().contentEquals("13") ||
                    s.getId().getStudyClass().getCode().contentEquals("15") ||
                    s.getId().getStudyClass().getCode().contentEquals("45")) {
                return Level.EDN_ANNUAL;
            } 
            return Level.UNDERGRADUATE;
        }).findFirst().get();
    }

    public Optional<StudyClass> getStudyClass(final AttendanceMode attendanceMode) {
        return plans.stream().filter(  p -> p.isEnabled() && p.getId().getStudyClass().getAttendanceModes().contains(attendanceMode) )
            .map(p -> p.getId().getStudyClass()).findFirst();
    }

    /**
     * Nivel
     */
    public enum Level {
        DEGREE,
        UNDERGRADUATE,
        UNDERGRADUATE_PROCURATOR,
        EDN_SEMESTER,
        EDN_ANNUAL,
        EDN_THREE_SEMESTER;
    }

    public boolean isEDN() {
        Level level = this.getLevel();
        if (level != null) {
            if (level.equals(Level.EDN_SEMESTER) || level.equals(Level.EDN_ANNUAL) || level.equals(Level.EDN_THREE_SEMESTER)) {
                return true;
            }
            return false;
        } else {
            throw new NotFoundException(String.format("Level Not Found for Career %s", this.name));
        }
    }
}
