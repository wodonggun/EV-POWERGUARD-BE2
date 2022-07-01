package com.evpowerguard.registration.web.rest;

import com.evpowerguard.registration.config.KafkaSseProducer;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.messaging.MessageChannel;
// import org.springframework.messaging.MessageHeaders;
// import org.springframework.messaging.support.GenericMessage;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration-kafka")
public class UserKafkaResource {

    // private final Logger log = LoggerFactory.getLogger(UserKafkaResource.class);
    // private final MessageChannel output;

    // public UserKafkaResource(@Qualifier(KafkaSseProducer.CHANNELNAME) MessageChannel output) {
    //     this.output = output;
    // }

    // @PostMapping("/publish")
    // public void publish(@RequestParam String message) {
    //     log.info("REST request the message : {} to send to Kafka topic ", message);
    //     Map<String, Object> map = new HashMap<>();
    //     map.put(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
    //     MessageHeaders headers = new MessageHeaders(map);
    //     output.send(new GenericMessage<>(message, headers));
    // }
}
