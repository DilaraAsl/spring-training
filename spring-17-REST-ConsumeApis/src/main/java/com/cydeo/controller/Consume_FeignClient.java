package com.cydeo.controller;

import com.cydeo.client.EmployeeClient;
import com.cydeo.client.UserClient;
import com.cydeo.dto.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Consume_FeignClient { // we must provide dtos when we are using FeignClient to consume
    private final UserClient userClient;
    private final EmployeeClient employeeClient;

    public Consume_FeignClient(UserClient userClient, EmployeeClient employeeClient) {
        this.userClient = userClient;
        this.employeeClient = employeeClient;
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<ResponseWrapper> getUsers(){
        return ResponseEntity.ok(new ResponseWrapper("User List Retrieved ",userClient.getUsers()));
        // we see the userClient.getUsers() the list of users in postman

    }
    @GetMapping("/api/v1/employee")// retrieving users through passing header -- we passed the header in EmployeeClient
    public ResponseEntity<ResponseWrapper> getEmployee(){// we are going to list all the users which are coming from the employee client
        return ResponseEntity.ok(new ResponseWrapper("Employee retrieved",employeeClient.getEmployee("6298ebfecd0551211fce37a6")));
    }
}
