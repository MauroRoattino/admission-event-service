package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * The persistent class for the UE_ALUMNO_ESTUDIOS database table.
 * 
 */
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="UE_ALUMNO_ESTUDIOS")
@JsonIgnoreProperties({"cambioColegio", "cantMatAdeud","estado","materiasRecuperadas1","materiasRecuperadas2","materiasRecuperadas3","materiasRecuperadas4","materiasRecuperadas5","materiasRecuperadas6","motivoCambio","observaciones", "otraLocalidadColegio", "otroColegio","otroTitulo", "repeticionAnio1", "repeticionAnio2", "repeticionAnio3", "repeticionAnio4", "repeticionAnio5", "repeticionAnio6", "paisId" })
public class PreviousStudies implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UE_ALU_EST_HIST_SEQ")
    @SequenceGenerator(name = "UE_ALU_EST_HIST_SEQ", sequenceName = "UE_ALU_EST_HIST_SEQ", allocationSize = 1)
	private long id;

	@ApiModelProperty(value = "The student id", example = "1")
    @ManyToOne
    @JoinColumn(name = "ALU_ID")
	private Student studentId;


	@Column(name="CAMBIO_COLEGIO")
	private Long cambioColegio;

	@Column(name="CANT_MAT_ADEUD")
	private Long cantMatAdeud;

	private Long estado;

	@Column(name="FECHA_EGRESO")
	private LocalDate graduationDate;

	@Column(name="IED_ID")
	private Long institutionId;

	@Column(name="MATERIAS_RECUPERADAS_1")
	private Long materiasRecuperadas1;

	@Column(name="MATERIAS_RECUPERADAS_2")
	private Long materiasRecuperadas2;

	@Column(name="MATERIAS_RECUPERADAS_3")
	private Long materiasRecuperadas3;

	@Column(name="MATERIAS_RECUPERADAS_4")
	private Long materiasRecuperadas4;

	@Column(name="MATERIAS_RECUPERADAS_5")
	private Long materiasRecuperadas5;

	@Column(name="MATERIAS_RECUPERADAS_6")
	private Long materiasRecuperadas6;

	@Column(name="MOTIVO_CAMBIO")
	private Long motivoCambio;

	private String observaciones;

	@Column(name="OTRA_LOCALIDAD_COLEGIO")
	private String otraLocalidadColegio;

	@Column(name="OTRO_COLEGIO")
	private String otroColegio;

	@Column(name="OTRO_TITULO")
	private String otroTitulo;

	@Column(name="PAIS_ID")
	private Long paisId;

	@Column(name="PROMEDIO_SEC")
	private Double average;

	@Column(name="REPETICION_ANIO_1")
	private Long repeticionAnio1;

	@Column(name="REPETICION_ANIO_2")
	private Long repeticionAnio2;

	@Column(name="REPETICION_ANIO_3")
	private Long repeticionAnio3;

	@Column(name="REPETICION_ANIO_4")
	private Long repeticionAnio4;

	@Column(name="REPETICION_ANIO_5")
	private Long repeticionAnio5;

	@Column(name="REPETICION_ANIO_6")
	private Long repeticionAnio6;

	@Column(name="TIN_ID")
	private Long titleId;
}