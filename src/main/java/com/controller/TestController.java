/*
 * Name: TestController.java
 * Date: Apr 3, 2021
 * Copyright (C) 2021 Copart, Inc. All rights reserved.
 */
package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.messaging.PublishEvent;

/**
 * @author srnareddy
 */
@RestController
@RequestMapping("/kafkaex/")
public class TestController {
    @Autowired
    private PublishEvent publishEvent;

    @PostMapping(value = "req9")
    public void m5(@RequestBody String request) {
        System.out.println("M9 method");
        publishEvent.publishEvent2(request);
        System.out.println("Publish Success");
    }
}
