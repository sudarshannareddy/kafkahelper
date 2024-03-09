/*
 * Name: BusinessObject.java
 * Date: Apr 19, 2021
 * Copyright (C) 2021 Copart, Inc. All rights reserved.
 */
package com.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author srnareddy
 *
 */
/**
 * Used as a general way to handle all data models abstractly.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BusinessObject implements Cloneable, Serializable
{
}
