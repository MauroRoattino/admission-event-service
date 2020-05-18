package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.persistence;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.VTickets;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Scholarship {


    private String description;

    @Builder.Default
    private Double percentage = 0d;

    @Builder.Default
    private Double fixedAmmount = 0d;

    @ApiModelProperty(example = "B", value = "B -> Beca, D->Discount")
    private String type;

    @ApiModelProperty(example = "2/19", value = "Codigo del periodo al cual aplica la beca")
    private String periodCode;

    @ApiModelProperty(example = "MM", value = "tipo del ticket al cual aplica la beca, MM -> Matrículas, II-> Aranceles")
    private String ticketType;



    public boolean match(VTickets t) {
        return  ticketType == null || ticketType.equals(t.getTipoticket());
    }


    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void apply(VTickets t) {
        if (fixedAmmount > 0) {
            percentage =  round( fixedAmmount / t.getValorBruto() * 100f,2);
        } 
        if (type.equals("B")) {
            t.setPorcentajeBeca(t.getPorcentajeBeca() + percentage);
        } else if (type.equals("D")) {
            t.setPorcentajeDescuento(t.getPorcentajeDescuento() + percentage);
        }
        t.getScholarships().add(this);
    }
    

}