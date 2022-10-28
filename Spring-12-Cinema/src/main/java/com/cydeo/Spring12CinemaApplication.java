package com.cydeo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class Spring12CinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring12CinemaApplication.class, args);
    }
// we are manually describing how flyaway will reach the data source
//    @Bean
//    public MigrateResult migrateResult(DataSource dataSource){
//        return Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();

}
