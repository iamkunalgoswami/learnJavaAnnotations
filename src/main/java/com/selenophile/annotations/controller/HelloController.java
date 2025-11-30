package com.selenophile.annotations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello World from Jetty!";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Test endpoint working!";
    }
}
