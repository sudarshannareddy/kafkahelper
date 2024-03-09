package com.kafkaconfig;

import com.controller.TestController;
import com.messaging.PublishEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class MessageScheduler {

    @Autowired
    private PublishEvent publishEvent;

    @Scheduled(fixedDelay = 5000)
    public void send() {
        System.out.println("Scheduler Started at=" + LocalDateTime.now());
        try {
            publishEvent.publishEvent2("Test Message-" + System.currentTimeMillis());
        } catch (Exception ex) {
            System.out.println("Scheduler Error=" + ex.getMessage());
        }
        System.out.println("Scheduler Ended at=" + LocalDateTime.now());
    }
}
