package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.persistence;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.exception.ServiceException;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalipsoCode {

    @ApiModelProperty(example = "WI.01.12.01.05.07.02.22.10.EH")
    private String id;

    @ApiModelProperty(example = "AM1")
    private String code;

    // rubro
    @ApiModelProperty(example = "AM")
    private String sector;

    @ApiModelProperty(example = "01")
    private String calypsoCareerId;

    @ApiModelProperty(example = "ARG-WI.01.12.01.05.07.02.22.10.EH")
    private String costCenter;

    @ApiModelProperty(example = "001")
    private String unidOp;

    @ApiModelProperty(example = "AM1")
    public String base;

    @ApiModelProperty(example = "1")
    public String productCode;

    public CalipsoCode(String id, String base, String unidOp) {
        this.id = id;
        this.code = base;
        this.unidOp = unidOp;
        this.sector = base.substring(0,2);
        this.base = base;
        this.productCode = base.substring(2);
        
        //CASE WHEN LEFT(id,6) = 'WI.01.' THEN substring(cc.codigo,10,2) ELSE substring(id,5,3) END as carrera
        if (id.startsWith("WI.01.")) {
            this.calypsoCareerId = id.substring(9,11);
        } else {
        	if (! (id.length() < 7)) {
            this.calypsoCareerId = id.substring(4,7);
        	}
        	else {
        		throw new ServiceException("Invalid calipso code id ");
        	}
        }
/*         CASE WHEN (CHARINDEX('.PE',cc.codigo) = 0 AND CHARINDEX('PER',cc.codigo) = 0) then 'ARG-'+cc.codigo           
        ELSE (CASE WHEN CHARINDEX('PER',cc.codigo) = 0 THEN 'PER-'+cc.codigo ELSE cc.codigo END)          
    END AS centro_costo,  */         
        
       if (id.indexOf(".PE") == -1 && id.indexOf("PER") == -1) {
           costCenter = "ARG-"+id;
       } else {
           if (id.indexOf("PER") == -1) {
                costCenter = "ARG-"+id;
           } else {
               costCenter = id;
           }
       }
     

    }
    
    public String getCalipsoForDiplomatura() {
    	return this.id + "-" + this.code;
    }
}