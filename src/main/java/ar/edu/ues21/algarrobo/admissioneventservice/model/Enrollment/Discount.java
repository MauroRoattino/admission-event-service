package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

    private String name;
    private boolean fixed;
    private Double percentage;
    private Double ammount;
    private VTickets parent;
}