package com.evpowerguard.registration.adaptor;

import java.util.concurrent.ExecutionException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.springframework.messaging.Message;

public interface RegistrationConsumer {
    
    /** kafka */
    void consume(Message<String> message);
    
    void consumeChargerStatusToBroken(Message<String> message) throws JsonMappingException, JsonProcessingException, NumberFormatException, InterruptedException, ExecutionException ;
}
