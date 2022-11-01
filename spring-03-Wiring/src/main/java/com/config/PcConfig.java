package com.config;

import com.casefactory.Case;
import com.casefactory.DellCase;
import com.casefactory.Dimensions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PcConfig {

    @Bean
    public Dimensions dimensions(){
        return new Dimensions(50,10,10);
    }


    @Bean
    public Case caseDell(Dimensions dimensions){ // Dependency injection
        return new DellCase("220B","Dell","240",dimensions);
    }
}
