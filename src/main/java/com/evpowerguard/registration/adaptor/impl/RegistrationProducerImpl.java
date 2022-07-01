package com.evpowerguard.registration.adaptor.impl;

import java.util.HashMap;
import java.util.Map;


import com.evpowerguard.registration.config.KafkaSseProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.util.MimeTypeUtils;
import com.evpowerguard.registration.adaptor.RegistrationProducer;
import com.evpowerguard.registration.domain.event.UserCreated;
import com.evpowerguard.registration.domain.event.UserDeleted;
import com.evpowerguard.registration.domain.event.UserUpdated;

@Service
public class RegistrationProducerImpl implements RegistrationProducer {

    private final Logger log = LoggerFactory.getLogger(RegistrationProducerImpl.class);
    private final MessageChannel output;

    private final ObjectMapper objectMapper = new ObjectMapper();
    
    public RegistrationProducerImpl(@Qualifier(KafkaSseProducer.CHANNELNAME) MessageChannel output) {
        this.output = output;
    }

    @Override
    public void createUser(UserCreated userCreated) throws ExecutionException, InterruptedException, JsonProcessingException
    {
        output.send((null));
        return;
    };

    public void updateUser(UserUpdated userUpdated) throws ExecutionException, InterruptedException, JsonProcessingException
    {
        output.send((null));
        return;
    };

    public void deleteUser(UserDeleted userDeleted) throws ExecutionException, InterruptedException, JsonProcessingException
    {
        output.send((null));
        return;
    };


    // @Override
    // public void updateChargerStatusToBroken(ChargerBroken chargerBroken) throws ExecutionException, InterruptedException, JsonProcessingException {
    //     log.info("================Kafka producer updateChargerStatusToBroken Send");
    //     String message = objectMapper.writeValueAsString(chargerBroken);

    //     Map<String, Object> map = new HashMap<>();
    //     map.put(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
    //     MessageHeaders headers = new MessageHeaders(map);

    //     output.send(new GenericMessage<>(message, headers));
    // }

    // @Override
    // public void updateChargerStatusToAvailable(ChargerRepairCompleted chargerRepairCompleted) throws ExecutionException, InterruptedException, JsonProcessingException {
    //     log.info("Kafka producer updateChargerStatusToAvailable Send");
    //     String message = objectMapper.writeValueAsString(chargerRepairCompleted);
        
    //     Map<String, Object> map = new HashMap<>();
    //     map.put(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
    //     MessageHeaders headers = new MessageHeaders(map);
        
    //     output.send(new GenericMessage<>(message, headers));
    // }
    
    // @Override
    // public void createBookmark(BookmarkCreated bookmarkCreated) throws ExecutionException, InterruptedException, JsonProcessingException {
    //     log.info("Kafka producer createBookmark Send");
    //     String message = objectMapper.writeValueAsString(bookmarkCreated);

    //     Map<String, Object> map = new HashMap<>();
    //     map.put(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
    //     MessageHeaders headers = new MessageHeaders(map);
        
    //     output.send(new GenericMessage<>(message, headers));
    // }

    // @Override
    // public void deleteBookmark(BookmarkDeleted bookmarkDeleted) throws ExecutionException, InterruptedException, JsonProcessingException {
    //     log.info("Kafka producer deleteBookmark Send");
    //     String message = objectMapper.writeValueAsString(bookmarkDeleted);

    //     Map<String, Object> map = new HashMap<>();
    //     map.put(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
    //     MessageHeaders headers = new MessageHeaders(map);
        
    //     output.send(new GenericMessage<>(message, headers));
    // }

}
