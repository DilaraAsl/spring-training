package com.entity;


import javax.persistence.*;
import java.math.BigDecimal;
//@Entity we don't want to create a table from this class
@MappedSuperclass // we want to create tables from  child classes -we just want the data to be passed to child classes
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;


}
