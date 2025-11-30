package com.selenophile.annotations;

import org.springframework.stereotype.Component;

/**
 * Hello world!
 * @Component annotation initializes the App class on Runtime
 * And We can observe the String "Hello World! from Constructor"
 * in the Output Console.
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

