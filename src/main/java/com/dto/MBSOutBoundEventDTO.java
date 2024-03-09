/*
 * Name: MBSOutBoundEventDTO.java
 * Date: Apr 19, 2021
 * Copyright (C) 2021 Copart, Inc. All rights reserved.
 */
package com.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author srnareddy
 *
 */
@Data
public class MBSOutBoundEventDTO extends BusinessObject
{

    private Long buyerNumber;
    private String entity;
    private String eventCode;
    private String correlationId;
    private String eventDatetime;

    private String siteCode;
    private String siteGroupCode;
    private String operatingCountry;

    @JsonProperty("txnKey")
    private String transactionKey;

    private Map<String, Object> eventInfo;

}
