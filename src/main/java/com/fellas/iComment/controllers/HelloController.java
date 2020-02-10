package com.fellas.iComment.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("start")
public class HelloController {
    @GetMapping
    public String sayHello() {
        return "Here we go!";
    }
}
