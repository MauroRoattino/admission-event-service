package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.persistence.Scholarship;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
//import lombok.var;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class VTickets{

    @ApiModelProperty(example = "435645")
    @JsonProperty("id")
    private String ticketNum;

    @ApiModelProperty(example = "Arancel A")
    @JsonProperty( "detail")
    private String ticketDetalle;

    @ApiModelProperty(example = "ARG-WI.01.12.01.05.07.02.22.10.EH")
    @JsonProperty( "costCenter")
    private String centroCosto;

    @ApiModelProperty(example = "WI.01.12.01.05.07.02.22.10.EH")
    @JsonIgnore
    private String centroCostoId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @ApiModelProperty(example = "2020-06-20T00:00:00")
    @JsonProperty("expires")
    private Date vence;

    @ApiModelProperty(example = "3")
    @JsonProperty( "installment")
    private String cuota;

    @ApiModelProperty(example = "3")
    @JsonProperty("installments")
    private String totalCuotas;

    @ApiModelProperty(example = "2020-05-21T15:25:28.684859")
    @JsonProperty( "date")
    private String fecha;

    @ApiModelProperty(example = "AM")
    @JsonProperty("sector")
    private String rubro;

    private EstadoPago estadoPago;
    
    private EstadoPagoDiplomatura estadoPagoDiplomatura;

    @ApiModelProperty(example = "S")
    private String enviado;

    @ApiModelProperty(example = "H")
    private String estadoContable ;

    @JsonIgnore
    private Context context;

    @ApiModelProperty(example = "C")
    private String codigoDiplomatura;

    @ApiModelProperty(example = "2")
    private String autorizado;

    @Builder.Default
    private List<Scholarship> scholarships = new ArrayList<>();

    public Double getPrice() {
        Double basePrice = getBasePrice();
        Double otherPromotions = descuentos.stream().map(d -> d.getAmmount() ).reduce(0d, Double::sum) ;
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

    @ApiModelProperty(example = "0")
    @JsonProperty("subjects")
    @Builder.Default()
    private int cantMaterias = 0;

    @ApiModelProperty(example = "0")
    @JsonProperty("scholarship")
    @Builder.Default()
    private double porcentajeBeca = 0d;

    @ApiModelProperty(example = "0")
    @JsonProperty("discount")
    @Builder.Default()
    private double porcentajeDescuento = 0d;

    @ApiModelProperty(example = "II")
    @JsonProperty("type")
    private String tipo;

    @ApiModelProperty(example = "5000.00")
    @JsonProperty("listPrice")
    @Builder.Default()
    private double valorBruto = 0d;

    @ApiModelProperty(example = "5")
    @JsonProperty("code")
    private String codigo;

    @ApiModelProperty(example = "ABG01798")
    @JsonProperty("studentRecord")
    private String legajo;

    @ApiModelProperty(example = "SR")
    private String region;

    @ApiModelProperty(example = "2")
    private String unidOpe;

    @ApiModelProperty(example = "0")
    private Integer idMon;

    @ApiModelProperty(example = "0")
    private Integer idSistemaOrigen;

    @ApiModelProperty(example = "100")
    private Integer points;

    @ApiModelProperty(example = "1/20")
    @JsonProperty("period")
    private String periodo;

    @ApiModelProperty(example = "D")
    @JsonProperty("group")
    private String modalidad;

    @ApiModelProperty(example = "01")
    @JsonProperty("career")
    private String carrera;

    @ApiModelProperty(example = "II")
    @JsonProperty("ticketType")
    private String tipoticket;

    @ApiModelProperty(example = "S/D")
    @JsonProperty("promotion")
    private String promocion;

    @ApiModelProperty(example = "0")
    @JsonProperty("calipsoPromotion")
    private String calipsoPromocion;

    @ApiModelProperty(example = "I")
    @JsonProperty("studentType")
    private String tipoalumno;

    @ApiModelProperty(example = "6432")
    @JsonProperty("schedule")
    private Integer turno;

    @ApiModelProperty(example = "3")
    private Integer cau;

    @ApiModelProperty(example = "1")
    @JsonProperty("tariffType")
    private Integer tipoArancel;

    @ApiModelProperty(example = "1")
    @JsonProperty("attendanceMode")
    private Integer tipoModalidad;

    @JsonProperty("discounts")
    @NonNull
    @Builder.Default()
    private List<Discount> descuentos = new ArrayList<>();

    @ApiModelProperty(example = "OLIOTTA")
    private String usrPortal;

    @ApiModelProperty(example = "12377168")
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

	    @ApiModelProperty(example = "PENDIENTE")
	    private final Integer valor;
        }

        public enum EstadoPagoDiplomatura{
	    PAGADO("F"),
	    PENDIENTE("P"),
	    ANULADO("A");
	
	    EstadoPagoDiplomatura(String v) {
		
		    this.valor = v;
		
	    }

	    @ApiModelProperty(example = "PENDIENTE")
	    private final String valor;

	    public String getValor() {
		return valor;
	}
        }
}
