package ar.edu.ues21.algarrobo.admissioneventservice.model;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Administration.AdministrationTicket;
import io.swagger.annotations.ApiModelProperty;

public class TicketEvent extends EventBase{

    @ApiModelProperty(name = "event data")
    private AdministrationTicket data;

    public TicketEvent(AdministrationTicket data, String eventType, String source) {
        this.data = data;
        this.setEventType(eventType);
        this.setSource(source);
    }

    public String getEventId() {
        return "id";
    }

    public AdministrationTicket getData() {
        return data;
    }

    public void setData(AdministrationTicket data) {
        this.data = data;
    }
}
