package com.selenophile.annotations.service;

import org.springframework.stereotype.Service;
/*
* Added one more implementation of
* Greet Interface
* */
@Service
public class GreetHi implements Greet{
    /**
     * @return Hi
     */
    @Override
    public String sayMessage() {
        return "Hi, Everyone.....";
    }
}
