package com.expedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * This is the main class for the Expedia application. It is responsible for bootstrapping the application using Spring Boot.
 * The class is annotated with @SpringBootApplication, which is a combination of @Configuration, @EnableAutoConfiguration, and @ComponentScan.
 * The @ComponentScan annotation is used to scan the "com.expedia.hotel" package to find Spring-managed components.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.expedia.hotel"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
