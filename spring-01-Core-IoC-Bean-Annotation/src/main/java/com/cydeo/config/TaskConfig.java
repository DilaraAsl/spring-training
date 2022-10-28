package com.cydeo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {
    @Bean
   public String myString(){ // string object returning a bean obj
        return "Cydeo"; // return into the container
    };
    @Bean
    Integer myInteger(){
        return 5; // return into the container
    };
}
