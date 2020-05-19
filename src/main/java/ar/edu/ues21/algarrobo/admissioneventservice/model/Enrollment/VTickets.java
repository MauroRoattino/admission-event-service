package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.persistence.Scholarship;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VTickets{

    @JsonProperty("id")
    private String ticketNum;

    @JsonProperty( "detail")
    private String ticketDetalle;

    @JsonProperty( "costCenter")
    private String centroCosto;

    @JsonIgnore
    private String centroCostoId;

    @JsonProperty("expires")
    private Date vence;

    @JsonProperty( "installment")
    private String cuota;

    @JsonProperty("installments")
    private String totalCuotas;

    @JsonProperty( "date")
    private String fecha;

    @JsonProperty("sector")
    private String rubro;
    
    private EstadoPago estadoPago;
    
    private EstadoPagoDiplomatura estadoPagoDiplomatura;
    
    private String enviado;
    
    private String estadoContable ;

    @JsonIgnore
    private Context context;
    
    private String codigoDiplomatura;
    
    private String autorizado;

    @Builder.Default
    private List<Scholarship> scholarships = new ArrayList<>();

    public Double getPrice() {
        Double basePrice = getBasePrice();
        var otherPromotions = descuentos.stream().map(d -> d.getAmmount() ).reduce(0d, Double::sum) ;
        return round( basePrice - otherPromotions ,2);

    }

    public Double getBasePrice() {
        return round( valorBruto - getDiscountAmmount(),2);
    }

    public Double getDiscountAmmount() {
        return round( valorBruto * ((porcentajeBeca + porcentajeDescuento) / 100d),2);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @JsonProperty("subjects")
    @Builder.Default()
    private int cantMaterias = 0;

    @JsonProperty("scholarship")
    @Builder.Default()
    private double porcentajeBeca = 0d;

    @JsonProperty("discount")
    @Builder.Default()
    private double porcentajeDescuento = 0d;

    @JsonProperty("type")
    private String tipo;

    @JsonProperty("listPrice")
    @Builder.Default()
    private double valorBruto = 0d;

    @JsonProperty("code")
    private String codigo;

    @JsonProperty("studentRecord")
    private String legajo;
    private String region;
    private String unidOpe;
    private Integer idMon;
    private Integer idSistemaOrigen;
    private Integer points;

    @JsonProperty("period")
    private String periodo;

    @JsonProperty("group")
    private String modalidad;

    @JsonProperty("career")
    private String carrera;

    @JsonProperty("ticketType")
    private String tipoticket;
    @JsonProperty("promotion")
    private String promocion;

    @JsonProperty("calipsoPromotion")
    private String calipsoPromocion;


    @JsonProperty("studentType")
    private String tipoalumno;

    @JsonProperty("schedule")
    private Integer turno;
    private Integer cau;
    @JsonProperty("tariffType")
    private Integer tipoArancel;

    @JsonProperty("attendanceMode")
    private Integer tipoModalidad;

    @JsonProperty("discounts")
    @NonNull
    @Builder.Default()
    private List<Discount> descuentos = new ArrayList<>();
    
    private String usrPortal;

    private Long priceId;

    
    public int getCoutaInt() {
		return  Integer.valueOf( this.getCuota());
	}

    public enum EstadoPago{
	PAGADO(1),
	PENDIENTE(2),
	ANULADO(3);
	
	    EstadoPago(Integer v) {
		    this.valor = v;
	    }

	    public Integer getValor() { return valor; }

	    private final Integer valor;
        }

        public enum EstadoPagoDiplomatura{
	    PAGADO("F"),
	    PENDIENTE("P"),
	    ANULADO("A");
	
	    EstadoPagoDiplomatura(String v) {
		
		    this.valor = v;
		
	    }
	
	    private final String valor;

	    public String getValor() {
		return valor;
	}
        }
}
