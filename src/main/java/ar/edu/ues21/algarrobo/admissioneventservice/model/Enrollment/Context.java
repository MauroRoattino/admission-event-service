package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.persistence.CalipsoCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Context {

	private Student student;

	private StudentRecord studentRecord;

	private CalipsoCode calipso;

	private Career career;
}
