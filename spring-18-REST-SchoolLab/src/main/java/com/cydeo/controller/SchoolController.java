package com.cydeo.controller;


import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;

import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.addressService = addressService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> readAllTeachers(){
        List<TeacherDTO> teachers=teacherService.findAll();
        return teachers;
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){
        return ResponseEntity.ok(new ResponseWrapper("All students retrieved successfully",studentService.findAll()));
    }
    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents(){
        ResponseWrapper responseWrapper=new ResponseWrapper("All parents retrieved successfully",parentService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(responseWrapper);
    }
    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> readAddressById(@PathVariable("id") Long addressId) throws Exception{
        return ResponseEntity.ok(new ResponseWrapper("Address retrieved successfully",addressService.findById(addressId)));
    }
    @PutMapping("/address/{id}")
    public AddressDTO updateAddress(@PathVariable("id") Long addressId,@RequestBody AddressDTO addressDTO) throws Exception{

        // we used @JsonIgnore annotation so addressDTO's id field is not set we have to set the id
        addressDTO.setId(addressId);
        return addressService.update(addressDTO);

    }
}
