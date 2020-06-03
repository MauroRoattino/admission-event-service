package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@JsonInclude(Include.NON_NULL)
public class PreviousStudies {

	private long id;

	private Student studentId;

	private Long cambioColegio;

	private Long cantMatAdeud;

	private Long estado;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@ApiModelProperty(example = "2018-06-31")
	private LocalDate graduationDate;

	private Long institutionId;

	private Long materiasRecuperadas1;

	private Long materiasRecuperadas2;

	private Long materiasRecuperadas3;

	private Long materiasRecuperadas4;

	private Long materiasRecuperadas5;

	private Long materiasRecuperadas6;

	private Long motivoCambio;

	@ApiModelProperty(example = "-")
	private String observaciones;

	@ApiModelProperty(example = "-")
	private String otraLocalidadColegio;

	@ApiModelProperty(example = "-")
	private String otroColegio;

	@ApiModelProperty(example = "-")
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