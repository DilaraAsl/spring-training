package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@NoArgsConstructor
@Data
@Entity
public class Location extends BaseEntity {

    private String name;
    private String address;
    private String postalCode;

    private String country;
    private String state;
    private String city;


}
