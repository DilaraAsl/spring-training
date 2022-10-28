package com.cydeo.streotype_annotation.casefactory;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public abstract class Case {

    private String model;
    private String manufacturer;
    private String powerSupply;
    private Dimensions dimensions;

    public Case(String model, String manufacturer, String powerSupply) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.powerSupply = powerSupply;
        this.dimensions=dimensions;
    }

    public abstract void pressPowerButton();

}
