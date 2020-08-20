package ar.edu.ues21.algarrobo.admissioneventservice.model;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Cau.Cau;
import io.swagger.annotations.ApiModelProperty;

public class CauEvent extends EventBase {
    @ApiModelProperty(name = "data")
    private Cau data;

    public CauEvent(Cau data, String eventType, String source) {
        this.data = data;
        this.setEventType(eventType);
        this.setSource(source);
    }

    public Cau getData() {
        return data;
    }

    public void setData(Cau data) {
        this.data = data;
    }
}
