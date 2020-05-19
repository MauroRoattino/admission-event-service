package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequestId{

    private Contact contact;

    private Long item;
}
