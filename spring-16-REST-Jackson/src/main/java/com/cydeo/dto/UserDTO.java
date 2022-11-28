package com.cydeo.dto;

import com.cydeo.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.cydeo.enums.UserRole;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class UserDTO {
    private String email;
    private String password;
    private String username;
    private UserRole role;
    private AccountDTO account;
}
