package com.selenophile.annotations.controller;

import com.selenophile.annotations.service.Greet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/autowire")
public class AutowireAnnotationController {
    @Autowired
    private Greet greet;
    @GetMapping("/greetHello")
    @ResponseBody
    public String greetHello(){
        return greet.sayMessage();
    }
}
