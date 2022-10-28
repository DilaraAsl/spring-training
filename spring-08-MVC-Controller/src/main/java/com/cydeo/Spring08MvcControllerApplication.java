package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
@SpringBootApplication
//@SpringBootApplication(exclude={AopAutoConfiguration.class}) // the classes that you don't want springboot to manage
public class Spring08MvcControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring08MvcControllerApplication.class, args);
    }

}
