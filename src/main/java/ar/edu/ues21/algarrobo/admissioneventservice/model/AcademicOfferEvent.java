package ar.edu.ues21.algarrobo.admissioneventservice.model;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicOffer.AcademicOffer;
import io.swagger.annotations.ApiModelProperty;

public class AcademicOfferEvent extends EventBase {
    @ApiModelProperty(name = "data")
    private AcademicOffer data;

    public AcademicOfferEvent(AcademicOffer data, String eventType, String source) {
        this.data = data;
        this.setEventType(eventType);
        this.setSource(source);
    }

    public AcademicOffer getData() {
        return data;
    }

    public void setData(AcademicOffer data) {
        this.data = data;
    }
}
