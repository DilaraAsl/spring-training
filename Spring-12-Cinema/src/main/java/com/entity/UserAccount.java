package com.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class UserAccount extends BaseEntity{

    private String email;
    private String password;
    private String username;
    @OneToOne(fetch=FetchType.LAZY)

    private AccountDetails accountDetails;


}
