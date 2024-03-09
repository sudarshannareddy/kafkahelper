/*
 * Name: LotEventDTO.java
 * Date: Apr 3, 2021
 * Copyright (C) 2021 Copart, Inc. All rights reserved.
 */
package com.dto.events;

import com.dto.BaseEventDTO;

import lombok.Data;

/**
 * @author srnareddy
 *
 */
@Data
public class LotEventDTO extends BaseEventDTO
{
    private String country;
    private LotEventInfoDTO eventInfo;
    private LotAttributesDTO lotAttributes;

}
