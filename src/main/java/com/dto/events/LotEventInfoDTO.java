/*
 * Name: LotEventInfoDTO.java
 * Date: Apr 3, 2021
 * Copyright (C) 2021 Copart, Inc. All rights reserved.
 */
package com.dto.events;

import java.math.BigDecimal;

import com.dto.BaseEventDTO;

import lombok.Data;

/**
 * @author srnareddy
 *
 */
@Data
public class LotEventInfoDTO extends BaseEventDTO
{
    private String titleReadyDate;
    private String offsiteFlag;
    private Long memberNumber;
    private BigDecimal highBidAmount;
    private BigDecimal minBidAmount;
    private Long totalMemberAmount;
    private Long memberBalanceDue;
    private String isGoAppLot;

}
