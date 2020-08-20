package ar.edu.ues21.algarrobo.admissioneventservice.constant;

import org.apache.kafka.clients.producer.ProducerConfig;

public class Constants {

    public static final String ACKS_CONFIG = "all";

    public static final Integer  BATCH_SIZE_CONFIG = 1024 * 1024; // 1 MB

    public static final Integer LINGER_MS_CONFIG = 5;
    public static final Integer BUFFER_MEMORY_CONFIG = 64 * 1024 * 1024; // 64 MB
    public static final Integer RETRIES_CONFIG = 3;
    public static final Integer REQUEST_TIMEOUT_MS_CONFIG = 15000;
    public static final Integer RETRY_BACKOFF_MS_CONFIG = 1000;

    public static final String COMPRESSION_TYPE_CONFIG = "gzip";

    public Constants() {
    }
}
