package com.fallabella.challenge.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.fallabella")
public class MsaProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaProductServiceApplication.class, args);
    }

}
