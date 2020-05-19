package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String usrPortal;

    private String active;
    
    private LocalDateTime fromDate;

    private LocalDateTime passwordExpiration;
}