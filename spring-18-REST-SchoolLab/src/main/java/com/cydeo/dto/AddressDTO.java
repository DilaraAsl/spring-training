package com.cydeo.dto;

import com.cydeo.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // ignore unknown fields entered by user
@JsonInclude(JsonInclude.Include.NON_NULL) // if non null display otherwise hide
public class AddressDTO {
    @JsonIgnore
    private Long id;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;

    private AddressType addressType;

    // we cannot use multiple @JsonBackReference on multiple fields w/o value
    @JsonBackReference(value="student-address-reference")
    private StudentDTO student;
    @JsonBackReference(value="parent-address-reference")
    private ParentDTO parent;
    @JsonBackReference(value="teacher-address-reference")
    private TeacherDTO teacher;

    private Integer currentTemperature; //weather information which we will later get from 3rd party api
// until i consume the api this field is going to be null
    // if we don't want to see the null fields ->@JsonInclude
}