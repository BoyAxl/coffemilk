package com.axlboy.coffemilk.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Configuration {
    @Bean("lblTitle")
    private String getTitle(){
        return "Bienvenido a CoffeMilk";
    }
}