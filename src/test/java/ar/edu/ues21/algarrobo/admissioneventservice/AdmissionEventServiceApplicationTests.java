package ar.edu.ues21.algarrobo.admissioneventservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.springframework.kafka.test.assertj.KafkaConditions.key;
import static org.springframework.kafka.test.hamcrest.KafkaMatchers.hasValue;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.EnrollmentEvent;
import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.Enrollment;
import ar.edu.ues21.algarrobo.admissioneventservice.service.ProducerService;

@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdmissionEventServiceApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdmissionEventServiceApplicationTests.class);

    private static String TOPIC_NAME = "admission.test.preenrollment";

    private static ObjectMapper objectMapper;

    @Autowired
    private ProducerService kafkaMessageProducerService;

    private KafkaMessageListenerContainer<String, EnrollmentEvent> container;

    private BlockingQueue<ConsumerRecord<String, String>> consumerRecords;

    @ClassRule
    public static EmbeddedKafkaRule embeddedKafka = new EmbeddedKafkaRule(1, true, TOPIC_NAME);

    EnrollmentEvent enrollmentEvent;


    @BeforeClass
    public static void generalSetUp() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Before
    public void perTestSetUp() throws JsonParseException, JsonMappingException, IOException {
        setupJSONsAndMocks();

        consumerRecords = new LinkedBlockingQueue<>();

        ContainerProperties containerProperties = new ContainerProperties(TOPIC_NAME);

        Map<String, Object> consumerProperties = KafkaTestUtils.consumerProps(
                "sender", "false", embeddedKafka.getEmbeddedKafka());

        DefaultKafkaConsumerFactory<String, EnrollmentEvent> consumer = new DefaultKafkaConsumerFactory<>(consumerProperties);

        container = new KafkaMessageListenerContainer<>(consumer, containerProperties);
        container.setupMessageListener((MessageListener<String, String>) record -> {
            LOGGER.debug("Listened message='{}'", record.toString());
            consumerRecords.add(record);
        });
        container.start();

        ContainerTestUtils.waitForAssignment(container, embeddedKafka.getEmbeddedKafka().getPartitionsPerTopic());
    }


    private void setupJSONsAndMocks() throws JsonParseException, JsonMappingException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file;

        file = new File(classLoader.getResource("mockdata/EnrollmentEvent.json").getFile());
        System.out.println(file.getAbsolutePath());
        enrollmentEvent = objectMapper.readValue(file, EnrollmentEvent.class);
    }

    @After
    public void tearDown() {
        if (container != null) container.stop();
    }

    @Test
    public void it_should_send_enrollment_event() throws InterruptedException, IOException {
        Enrollment enrollment = enrollmentEvent.getData();
        kafkaMessageProducerService.sendEnrollmentEvent(enrollment, enrollmentEvent.getEventType(), "pre-enrollment-event-test");

        ConsumerRecord<String, String> received = consumerRecords.poll(10, TimeUnit.SECONDS);

        String json = objectMapper.writeValueAsString(enrollmentEvent);

        assertThat(received, hasValue(json));

        assertThat(received).has(key(null));
    }
}
