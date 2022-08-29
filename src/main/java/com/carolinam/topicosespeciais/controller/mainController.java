package com.carolinam.topicosespeciais.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

    @GetMapping // método GET
    public String hello() {
        return "hello";
    }
}
