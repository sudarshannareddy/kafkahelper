/*
 * Name: LotAttributesDTO.java
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
public class LotAttributesDTO extends BaseEventDTO
{
    private Integer lotStage;
    private Integer yardNumber;
    private String lotStatus;
    private Long lotNumber;
    private String lotType;
    private String sellerNumber;

}
