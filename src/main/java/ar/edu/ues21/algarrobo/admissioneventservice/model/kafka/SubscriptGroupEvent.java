package ar.edu.ues21.algarrobo.admissioneventservice.model.kafka;

import ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.SubscriptGroup;

public class SubscriptGroupEvent extends EventBase{

    private SubscriptGroup data;

    public SubscriptGroupEvent(SubscriptGroup data, String eventType, String eventSource) {
        this.data = data;
        this.setEventType(eventType);
        this.setSource(eventSource);
    }

    @Override
    public String getEventId() {
        return data.getExternalId();
    }

    public SubscriptGroup getData() {
        return data;
    }

    public void setData(SubscriptGroup data) {
        this.data = data;
    }
}
