/*
 * Name: BaseEventDTO.java
 * Date: Apr 3, 2021
 * Copyright (C) 2021 Copart, Inc. All rights reserved.
 */
package com.dto;

import lombok.Data;

/**
 * @author srnareddy
 *
 */
@Data
public class BaseEventDTO extends BusinessObject
{

    private String entity;
    private String eventType;
    private String correlationId;
    private String eventDatetime;

    private Long memberId;
    private Integer buyerNumber;
    private String siteCode;
    private String siteGroupCode;
    private String operatingCountry;

}
