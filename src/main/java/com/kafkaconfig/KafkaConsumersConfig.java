/*
 * Name: KafkaConsumersConfig.java
 * Date: Apr 19, 2021
 * Copyright (C) 2021 Copart, Inc. All rights reserved.
 */
package com.kafkaconfig;

import com.deserializer.KafkaGenericDeserializer;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

/**
 * @author srnareddy
 */
@Configuration
public class KafkaConsumersConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public ConsumerFactory<String, String> lotEventConsumerFactory() {
        final KafkaGenericDeserializer<String> casOutBoundEventDeserializer = new KafkaGenericDeserializer<>(new TypeReference<String>() {
        });
        Map<String, Object> consumerConfig = kafkaProperties.buildConsumerProperties();
        return new DefaultKafkaConsumerFactory<>(consumerConfig, new StringDeserializer(), casOutBoundEventDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> lotEventKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(lotEventConsumerFactory());
        return factory;
    }

}
