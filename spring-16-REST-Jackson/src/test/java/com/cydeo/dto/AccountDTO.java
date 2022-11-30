package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;
    @JsonBackReference // hide UserDto -this field is not going to be serialized -java to json conversion won't happen
    // in user class AccountDTO is a field and in this class UserDTo is a field which causes stack overflow error
    private UserDTO user;

}
