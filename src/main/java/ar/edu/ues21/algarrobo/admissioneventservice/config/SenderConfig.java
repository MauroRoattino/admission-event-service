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
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class SenderConfig {

    @Value("${kafka.config.path}")
    private String KAFKA_CONFIG_PATH;

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> map;

        try {
            map = loadConfig(KAFKA_CONFIG_PATH);
        } catch (final IOException e) {
            map = new HashMap<>();
            map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        }

        map.putIfAbsent(ProducerConfig.ACKS_CONFIG, "all");
        map.putIfAbsent(ProducerConfig.CLIENT_ID_CONFIG, "admission-event");
        map.putIfAbsent(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);

        map.putIfAbsent(ProducerConfig.BATCH_SIZE_CONFIG, 12000 * 200);
        map.putIfAbsent(ProducerConfig.LINGER_MS_CONFIG, 5);
        map.putIfAbsent(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");

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

    private static Map<String, Object> loadConfig(final String configFile) throws IOException {
        final File file = new File(configFile);
        
        System.out.println(file.getAbsolutePath());

        final Properties cfg = new Properties();
        try (InputStream inputStream = new FileInputStream(file)) {
            cfg.load(inputStream);
        }

        Stream<Entry<Object, Object>> stream = cfg.entrySet().stream();
        Map<String, Object> mapOfProperties = stream.collect(Collectors.toMap(
                e -> String.valueOf(e.getKey()),
                e -> e.getValue()));

        return mapOfProperties;
    }
}
