package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


/**
 * The persistent class for the UE_ALUMNO_ESTUDIOS database table.
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"cambioColegio", "cantMatAdeud","estado","materiasRecuperadas1","materiasRecuperadas2","materiasRecuperadas3","materiasRecuperadas4","materiasRecuperadas5","materiasRecuperadas6","motivoCambio","observaciones", "otraLocalidadColegio", "otroColegio","otroTitulo", "repeticionAnio1", "repeticionAnio2", "repeticionAnio3", "repeticionAnio4", "repeticionAnio5", "repeticionAnio6", "paisId" })
public class PreviousStudies {

	private long id;

	@ApiModelProperty(value = "The student id", example = "1")
	private Student studentId;

	private Long cambioColegio;

	private Long cantMatAdeud;

	private Long estado;

	private LocalDate graduationDate;

	private Long institutionId;

	private Long materiasRecuperadas1;

	private Long materiasRecuperadas2;

	private Long materiasRecuperadas3;

	private Long materiasRecuperadas4;

	private Long materiasRecuperadas5;

	private Long materiasRecuperadas6;

	private Long motivoCambio;

	private String observaciones;

	private String otraLocalidadColegio;

	private String otroColegio;

	private String otroTitulo;

	private Long paisId;

	private Double average;

	private Long repeticionAnio1;

	private Long repeticionAnio2;

	private Long repeticionAnio3;

	private Long repeticionAnio4;

	private Long repeticionAnio5;

	private Long repeticionAnio6;

	private Long titleId;
}