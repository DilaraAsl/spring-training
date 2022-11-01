package com.entity;

import com.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@NoArgsConstructor
@Data
@AllArgsConstructor // it does not get the parent field it should work in this case
@Entity
@Table(name="employees")
public class Employee extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
   Gender gender;
   private int salary;


}
