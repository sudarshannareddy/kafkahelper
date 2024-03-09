/*
 * Name: LotEventsSerializer.java
 * Date: Apr 19, 2021
 * Copyright (C) 2021 Copart, Inc. All rights reserved.
 */
package com.serializer;

import org.springframework.kafka.support.serializer.JsonSerializer;

import com.dto.events.LotEventDTO;

/**
 * @author srnareddy
 *
 */
public class LotEventsSerializer extends JsonSerializer<LotEventDTO>
{

}
