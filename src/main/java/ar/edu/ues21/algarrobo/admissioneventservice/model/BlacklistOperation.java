package ar.edu.ues21.algarrobo.admissioneventservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlacklistOperation {
    @NotNull
    private boolean activate;
}
