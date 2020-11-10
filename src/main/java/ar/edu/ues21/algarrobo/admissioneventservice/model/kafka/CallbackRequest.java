package ar.edu.ues21.algarrobo.admissioneventservice.model.kafka;

public class CallbackRequest {

    private String id;
    private String eventType;
    private ClusterResponseMetadata clusterResponseMetadata;
    private String exceptionMessage;

    public CallbackRequest(String id, String eventType, ClusterResponseMetadata clusterResponseMetadata, String exceptionMessage) {
        this.id = id;
        this.eventType = eventType;
        this.clusterResponseMetadata = clusterResponseMetadata;
        this.exceptionMessage = exceptionMessage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public ClusterResponseMetadata getClusterResponseMetadata() {
        return clusterResponseMetadata;
    }

    public void setClusterResponseMetadata(ClusterResponseMetadata clusterResponseMetadata) {
        this.clusterResponseMetadata = clusterResponseMetadata;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
