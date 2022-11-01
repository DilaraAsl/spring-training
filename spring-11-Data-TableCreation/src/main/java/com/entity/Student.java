package com.entity;

import com.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="students") //table name should be lower case and plural

public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // postgres assigns the identity for the objects if we use this annotation
    private Long id;



    @Column(name = "studentFirstName")// when we manually want to create a column name
    private String firstName; // camel case automatically changed to first_name in postgress
    @Column(name = "studentLastName")
    private String lastName;
    private String email;

    @Column(columnDefinition = "DATE") //type date is in postgres
    private LocalDate birthDate;
    @Column(columnDefinition = "TIME") //type time is in postgres
    private LocalTime birthTime;
    @Column(columnDefinition = "TIMESTAMP")// type timestamp is in postgres
    private LocalDateTime birthDateTime;

    @Enumerated(EnumType.STRING)
//    @Enumerated(EnumType.ORDINAL) FOR INTEGER TYPES
    private Gender gender;

    @Transient // when you don't want to add the city column in the database table
    private String city;  // -- we don't want city in the table but we want to keep it as a field




}
