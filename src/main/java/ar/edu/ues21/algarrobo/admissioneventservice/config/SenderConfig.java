package ar.edu.ues21.algarrobo.admissioneventservice.config;

import ar.edu.ues21.algarrobo.admissioneventservice.model.EnrollmentEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.StudentRecordEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.UserContactEvent;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
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

import static ar.edu.ues21.algarrobo.admissioneventservice.constant.Constants.*;

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
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        map.putIfAbsent(ProducerConfig.ACKS_CONFIG, ACKS_CONFIG);
        //map.putIfAbsent(ProducerConfig.BATCH_SIZE_CONFIG, BATCH_SIZE_CONFIG);
        map.putIfAbsent(ProducerConfig.LINGER_MS_CONFIG, LINGER_MS_CONFIG);
        map.putIfAbsent(ProducerConfig.COMPRESSION_TYPE_CONFIG, COMPRESSION_TYPE_CONFIG);
        map.putIfAbsent(ProducerConfig.BUFFER_MEMORY_CONFIG, BUFFER_MEMORY_CONFIG);
        map.putIfAbsent(ProducerConfig.RETRIES_CONFIG, RETRIES_CONFIG);
        map.putIfAbsent(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, REQUEST_TIMEOUT_MS_CONFIG);
        map.putIfAbsent(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, RETRY_BACKOFF_MS_CONFIG);

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
    
    @Bean
    public Producer<String, EnrollmentEvent> enrollmentEventProducer() {
        Map<String, Object> props = producerConfigs();
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "enrollment-producer");
        return new KafkaProducer<>(props);
    }
    
    @Bean
    public Producer<String, UserContactEvent> userContactEventProducer() {
        Map<String, Object> props = producerConfigs();
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "user-contact-producer");
        return new KafkaProducer<>(props);
    }
    
    @Bean
    public Producer<String, StudentRecordEvent> studentRecordEventProducer() {
        Map<String, Object> props = producerConfigs();
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "student-record-producer");
        return new KafkaProducer<>(props);
    }
}
