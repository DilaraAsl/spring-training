package com.cydeo.dto;

import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value={"address","country","state"},ignoreUnknown = true)
// ignoreUnknown true for extra fields that are unkown to our application -unknown will be totally ignored for security reasons
// if we don't have this our application will try to match the fields even if there is no match it will display
public class UserDTO {

    private String email;
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY) // fields are called property in json - property indicates a field
    //we can only write the password not read it
    private String password;//the password info should not be sent to UI
    private String username;
    private UserRole role;
    @JsonManagedReference //show AccountDTO -this field is going to be serialized
    private AccountDTO account;

}

