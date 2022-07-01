package com.evpowerguard.registration.adaptor.impl;

import java.util.Map;

//import com.evpowerguard.registration.domain.event.BreakdownReportSubmitted;
import com.evpowerguard.registration.service.UserService;
import com.evpowerguard.registration.adaptor.RegistrationConsumer;
import com.evpowerguard.registration.config.KafkaSseConsumer;
import com.evpowerguard.registration.config.KafkaSseProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.Message;
 

@Service
public class RegistrationConsumerImpl implements RegistrationConsumer {

    private final Logger log = LoggerFactory.getLogger(RegistrationConsumerImpl.class);
    private final MessageChannel output;
    
    private final UserService userService;
    
    public RegistrationConsumerImpl(@Qualifier(KafkaSseProducer.CHANNELNAME) MessageChannel output, UserService userService) {
        this.output = output;
        this.userService = userService;        
    }

    @Override
    @StreamListener(value = KafkaSseConsumer.CHANNELNAME, copyHeaders = "false")
    public void consume(Message<String> message) {
        //log.info("Got All message from kafka stream : {}", message.getPayload());
        System.out.println("kafka 1");
        log.info("Got All message from kafka stream : consume");
        System.out.println("kafka 2");
    } 

    @Override
    @StreamListener(value = KafkaSseConsumer.CHANNELNAME, copyHeaders = "false")
    public void consumeChargerStatusToBroken(Message<String> message) throws JsonMappingException, JsonProcessingException, NumberFormatException, InterruptedException, ExecutionException {
        System.out.println("kafka 3");
        log.info("Got consumeChargerStatusToBroken from kafka stream : consumeChargerStatusToBroken : 1");
        System.out.println("kafka 4");
        // log.info("Got consumeChargerStatusToBroken from kafka stream: 2 : " + message.getPayload());
        // BreakdownReportSubmitted chargerBroken = new BreakdownReportSubmitted();
        // log.info("Got consumeChargerStatusToBroken from kafka stream: 3");
        // Map<String, String> mapChargerBroken = chargerBroken.validate(message.getPayload());
        // log.info("Got consumeChargerStatusToBroken from kafka stream: 4");
        // if(mapChargerBroken == null)
        //     return;

        // log.info("Got consumeChargerStatusToBroken 2 from kafka stream: id {}", mapChargerBroken.get("breakdownChargerId"));

        // chargerService.updateChargerStatusToBroken(Long.parseLong(mapChargerBroken.get("id")));
    }
}
