package com.cydeo.dto;
import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value={"address","country","state"},ignoreUnknown = true)
//Unknown properties that do not exist in our app, that do not have a corresponding field
// will not be mapped,  they will be  ignored
// this protects our app from unknown requests
public class UserDTO {
    private String email;

    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY) //we can only write the password not read it
    private String password; //the password should not be sent to UI

    private String username;
    private UserRole role;


    @JsonManagedReference // this field is going to be serialized while UserDTO in AccountDTO will not be serialized
    private AccountDTO account;  // AccountDTO and UserDTO have bidirectional relationship this causes infinite recursion if we do not add annotaions to handle this

}
