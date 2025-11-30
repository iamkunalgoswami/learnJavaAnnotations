package com.selenophile.annotations.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
/*
* Primary Implementation of Greet Interface
* */
@Service
@Primary
public class GreetHello implements Greet{
    @Override
    public String sayMessage() {
        return "Hello,To Everyone....";
    }
}
