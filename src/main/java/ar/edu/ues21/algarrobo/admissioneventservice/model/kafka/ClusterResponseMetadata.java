package ar.edu.ues21.algarrobo.admissioneventservice.model.kafka;

import io.swagger.annotations.ApiModelProperty;
import org.apache.kafka.clients.producer.RecordMetadata;

public class ClusterResponseMetadata {

    @ApiModelProperty(name = "topic", example = "admission.enrollment")
    private String topic;

    @ApiModelProperty(name = "partition", example = "1")
    private int partition;

    @ApiModelProperty(name = "offset", example = "54201")
    private long offset;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getPartition() {
        return partition;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public ClusterResponseMetadata(RecordMetadata recordMetadata) {
        this.topic = recordMetadata.topic();
        this.partition = recordMetadata.partition();
        this.offset = recordMetadata.offset();
    }
}
