package com.evpowerguard.registration.config;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractEvent {

    //private final Logger log = LoggerFactory.getLogger(AbstractEvent.class);

    String resourceSystem;
    String eventType;
    Long timestamp;

    public AbstractEvent(){
        this.setEventType(this.getClass().getSimpleName());
        this.timestamp = System.currentTimeMillis();
        this.resourceSystem = "REGISTRATION"; 
        //this.resourceSystem = this.getClass().getPackage().getName();
    }

    public String toJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;

        try {
            json = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON format exception", e);
        }

        return json;
    }

    public boolean validate(){
        return getEventType().equals(getClass().getSimpleName());
    }

    public Map<String, String> validate(String message) throws JsonMappingException, JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper(); 
        String json = message; 
        Map<String, String> map = new HashMap<String, String>(); 
        map = mapper.readValue(json, new TypeReference<Map<String, String>>(){}); 
        //log.info(map.get("eventType"));

        if(map.get("eventType").equals(getClass().getSimpleName()) && !map.get("resourceSystem").equals(this.resourceSystem)) {
            return map;
        }
        return null;
    }
}