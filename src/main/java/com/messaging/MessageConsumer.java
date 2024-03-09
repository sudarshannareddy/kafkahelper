/*
 * Name: MessageConsumer.java
 * Date: Apr 19, 2021
 * Copyright (C) 2021 Copart, Inc. All rights reserved.
 */
package com.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author srnareddy
 */
@Component
public class MessageConsumer {

    @KafkaListener(topics = "ESCO-CONTAINERTEST-TOPIC", groupId = "test", containerFactory = "lotEventKafkaListenerContainerFactory")
    public void consumeMessage2(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, @Payload String message) {
        System.out.println("Topic=ESCO-CONTAINERTEST-TOPIC, Message2=" + message + ", partition=" + partition + ", time=" + LocalDateTime.now());
    }

}
