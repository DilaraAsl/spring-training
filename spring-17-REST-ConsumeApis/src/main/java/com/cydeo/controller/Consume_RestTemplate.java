package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/cydeo")
public class Consume_RestTemplate {
    private final String URI="https://jsonplaceholder.typicode.com/users"; // this is what we are consuming
    private final RestTemplate restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping// will consume the json place holder
    public ResponseEntity<User[]> readAllUsers(){
       return restTemplate.getForEntity(URI, User[].class);// restTemplate is returning ResponseEntity
        // we are able to manipulate the dto for example we can hide fields by using @JsonIgnore
    }
    @GetMapping("{id}")
    public Object readUser(@PathVariable("id") Integer id){
        String URL=URI+"/{id}";
        return restTemplate.getForObject(URL, Object.class,id); // getForObject no need for dto jackson won't do any mapping
        // we cannot manipulate for example  we cannot hide any fields
        // end point-- id should be provided as a parameter
    }
@GetMapping("/test")
public ResponseEntity<Object> consumePostFromDummyApi(){

    HttpHeaders headers =new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.set("app-id","6298ebfecd0551211fce37a6"); // we are setting the header because we cannot access the data without this info --security

    HttpEntity<String> entity = new HttpEntity<>(headers);
  return restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET, entity, Object.class);
  // when we are passing a header we use exchange method

}
}
