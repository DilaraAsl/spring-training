package com.entity;

import com.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class AccountDetails extends BaseEntity
{


    private String address;

    private  int age;

    private String city;
    private String country;
    private String name;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String state;

    @OneToOne(mappedBy = "accountDetails")
    private UserAccount account;


}
