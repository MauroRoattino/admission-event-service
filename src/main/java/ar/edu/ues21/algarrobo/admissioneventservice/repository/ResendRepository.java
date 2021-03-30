package ar.edu.ues21.algarrobo.admissioneventservice.repository;

import ar.edu.ues21.algarrobo.admissioneventservice.model.kafka.EventBase;
import ar.edu.ues21.algarrobo.admissioneventservice.service.ResendService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Repository
public class ResendRepository {

    private final static String RESEND_BLACKLIST_MAP = "resend-blacklist";

    private final DB db;

    private static final Logger LOGGER = LoggerFactory.getLogger(ResendService.class);

    private final ObjectMapper objectMapper;

    @Autowired
    public ResendRepository(@Value("${resend.file-location}") String resendFileLocation,
                         ObjectMapper objectMapper) {
        try {
            Files.createDirectories(Paths.get(resendFileLocation));
        } catch (IOException e) {
            LOGGER.error("Error while creating resend map directory");
        }
        db = openConnection(resendFileLocation + "/eventsToResend.db");
        this.objectMapper = objectMapper;
    }

    private DB openConnection(String resendFileLocation) {
        return DBMaker.fileDB(resendFileLocation).fileMmapEnableIfSupported().closeOnJvmShutdown().make();
    }

    private ConcurrentMap<String, String> getMap(String mapName) {
        return db.hashMap(mapName, Serializer.STRING, Serializer.STRING).createOrOpen();
    }

    public void addEventToMap(String topicName, String key, EventBase event) {
        ConcurrentMap<String, String> map = getMap(topicName);
        try {
            map.put(key, objectMapper.writeValueAsString(event));
        } catch (JsonProcessingException e) {
            LOGGER.error("Error while serializing event");
        }
        db.commit();
    }

    public void deleteEventFromMapIfExists(String topicName, String key) {
        ConcurrentMap<String, String> map = getMap(topicName);
        map.remove(key);
        db.commit();
    }

    public void addTopicToBlacklist(String topicName) {
        ConcurrentMap<String, String> map = getMap(RESEND_BLACKLIST_MAP);
        map.put(topicName, "1");
        db.commit();

    }

    public void removeTopicFromBlacklist(String topicName) {
        ConcurrentMap<String, String> map = getMap(RESEND_BLACKLIST_MAP);
        map.remove(topicName);
        db.commit();

    }

    public Boolean isTopicInBlacklist(String topicName) {
        ConcurrentMap<String, String> map = getMap(RESEND_BLACKLIST_MAP);
        return map.keySet().contains(topicName);
    }

    public List<String> getBlacklistAsList() {
        ConcurrentMap<String, String> map = getMap(RESEND_BLACKLIST_MAP);
        List<String> blacklistedTopics = new ArrayList<>();
        map.keySet().stream()
                .forEach(topicName -> blacklistedTopics.add(topicName));

        return blacklistedTopics;
    }

    public List<EventBase> getEventsFromMap(String topicName, Class<? extends EventBase> eventTypeClass) {
        ConcurrentMap<String, String> map = getMap(topicName);
        db.commit();
        List<EventBase> events;

        events = map.values()
                .stream()
                .map(event -> {
                    EventBase eventRead = null;
                    try {
                        eventRead = objectMapper.readValue(event, eventTypeClass);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return eventRead;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return events;
    }
}
