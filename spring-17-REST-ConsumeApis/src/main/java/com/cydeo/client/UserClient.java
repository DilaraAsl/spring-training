package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
//https://jsonplaceholder.typicode.com/users we are consuming this url
@FeignClient(url = "https://jsonplaceholder.typicode.com",name="USER-CLIENT") // any name can be given in microservices naming is important
public interface UserClient {
    @GetMapping("/users") // api end point we are consuming from the third party
    List<User> getUsers();// whenever we call this method anywhere in the application it will hit the end point above the end point will be executed with @GetMapping

}
