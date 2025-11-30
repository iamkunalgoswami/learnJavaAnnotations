package com.selenophile.annotations.service;

import org.springframework.stereotype.Service;

@Service
public class GreetHello implements Greet{
    @Override
    public String sayMessage() {
        return "Hello,To Everyone....";
    }
}
