package ar.edu.ues21.algarrobo.admissioneventservice.config;

import ar.edu.ues21.algarrobo.admissioneventservice.model.EnrollmentEvent;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class SenderConfig {

    @Value("${kafka.config.path}")
    private String KAFKA_CONFIG_PATH;

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> map = new HashMap<>();

        Properties props = new Properties();
        try {
            props = loadConfig(KAFKA_CONFIG_PATH);
        } catch (final IOException e) {
            props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        }

        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "producer-prototype");
        props.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);

        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 12000 * 200);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 5);
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");

        map = (Map) props;

        return map;
    }

    @Bean
    public ProducerFactory<String, EnrollmentEvent> enrollmentEventProducerFactory() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        final JsonSerializer<EnrollmentEvent> jsonSerializer = new JsonSerializer<EnrollmentEvent>(objectMapper);

        return new DefaultKafkaProducerFactory<>(producerConfigs(), new StringSerializer(), jsonSerializer);
    }

    @Bean
    public KafkaTemplate<String, EnrollmentEvent> kafkaEnrollmentEventTemplate() {
        return new KafkaTemplate<>(enrollmentEventProducerFactory());
    }

    private static Properties loadConfig(final String configFile) throws IOException {
        final File file = new File(configFile);
        
        System.out.println(file.getAbsolutePath());

        final Properties cfg = new Properties();
        try (InputStream inputStream = new FileInputStream(file)) {
            cfg.load(inputStream);
        }
        return cfg;
    }
}
