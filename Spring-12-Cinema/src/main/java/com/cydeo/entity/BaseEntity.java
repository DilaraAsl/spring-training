package com.cydeo.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
//@Entity  we are not using entity because we are not creating a table from this class
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
