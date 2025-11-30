package com.selenophile.annotations;

import org.springframework.stereotype.Component;

/**
 * Hello world!
 */
@Component
public class App {
    App(){
        System.out.println("Hello World! from Constructor");

    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

