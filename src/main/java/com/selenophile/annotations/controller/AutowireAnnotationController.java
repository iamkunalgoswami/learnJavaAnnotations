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
    private final Greet greetHello;
    private final Greet greetHi;

    @Autowired
    public AutowireAnnotationController(Greet greetHello, @Qualifier("greetHi") Greet greetHi) {
        this.greetHello = greetHello;
        this.greetHi = greetHi;
    }

    /*
    * Added one more implementation of Greet Interface
    * @GreetHello
    * @GreetHi
    * Hence to resolve conflict,
    * we need to qualify the bean to be injected.
    * */

    @GetMapping("/greetHi")
    @ResponseBody
    public String greetHi(){
        return greetHi.sayMessage();
    }

    @GetMapping("/greetHello")
    @ResponseBody
    public String greetHello(){
        return greetHello.sayMessage();
    }


}
