/*
 * Name: KafkaGenericDeserializer.java
 * Date: Apr 3, 2021
 * Copyright (C) 2021 Copart, Inc. All rights reserved.
 */
package com.deserializer;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author srnareddy
 *
 */
@Slf4j
public class KafkaGenericDeserializer<T> implements Deserializer<T>
{
    private final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
        .featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .serializationInclusion(JsonInclude.Include.NON_NULL)
        .build();

    private final TypeReference<T> typeReference;

    public KafkaGenericDeserializer(TypeReference<T> typeReference)
    {
        this.typeReference = typeReference;
    }

    @Override
    public void configure(final Map<String, ?> settings, final boolean isKey)
    {

    }

    @Override
    public T deserialize(final String topic, final byte[] data)
    {
        if (data == null)
        {
            return null;
        }

        try
        {
            return objectMapper.readValue(new String(data), typeReference);
        }
        catch (final Exception e)
        {
            // DO NOT THROW ANY EXCEPTION Just log it -- Don't change it
            // throw new SerializationException("Can't deserialize data [" +
            // Arrays.toString(data) + "] from topic [" + topic + "]", e);
            log.error("Can't deserialize data [" + new String(data) + "] from topic [" + topic + "]", e);
            return null;
        }
    }

    @Override
    public void close()
    {

    }
}
