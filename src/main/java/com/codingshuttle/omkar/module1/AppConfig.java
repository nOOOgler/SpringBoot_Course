package com.codingshuttle.omkar.module1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")                       //to create to different objects with different memory locations
    PaymentService paymentService(){

        return new PaymentService();
    }

    @PostConstruct
    public void firstMethod(){
        System.out.println("this runs at the very beginning due to annotations");
    }

    @PreDestroy
    public void lastMethod(){
        System.out.println("This runs very last when we stop code, due to annotations");
    }
}
