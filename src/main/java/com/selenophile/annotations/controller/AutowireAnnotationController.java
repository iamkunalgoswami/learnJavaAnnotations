package com.selenophile.annotations.controller;

import com.selenophile.annotations.service.Greet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/autowire")
public class AutowireAnnotationController {

    /*
    * Added one more implementation of Greet Interface
    * @GreetHello
    * @GreetHi
    * Hence to resolve conflict,
    * we need to qualify the bean to be injected.
    * */
    @Autowired
    @Qualifier("greetHi")
    private Greet greet;
    @GetMapping("/greetHello")
    @ResponseBody
    public String greetHi(){
        return greet.sayMessage();
    }
}
