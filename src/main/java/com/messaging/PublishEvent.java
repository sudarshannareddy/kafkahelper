/*
 * Name: PublishEvent.java
 * Date: Apr 19, 2021
 * Copyright (C) 2021 Copart, Inc. All rights reserved.
 */
package com.messaging;

import com.dto.events.LotEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author srnareddy
 */
@Service
public class PublishEvent {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishEvent2(String request) {
        System.out.println("PublishEvent2 started");
        String topicName = "ESCO-CONTAINERTEST-TOPIC";
        Message<String> eventMessage = MessageBuilder.withPayload(request).setHeader(KafkaHeaders.MESSAGE_KEY, "" + System.currentTimeMillis()).setHeader(KafkaHeaders.TOPIC, topicName).build();
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(eventMessage);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Success");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Failed");
            }
        });

    }

}
