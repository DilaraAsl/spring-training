package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {
    private final CourseService courseService;

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new ResponseWrapper("Courses successfully retrieved",courseService.getCourses()));
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") long courseId){
        return ResponseEntity
                .ok(new ResponseWrapper("Course :"+courseId+" is retrieved",courseService.getCourseById(courseId)));

    }
    @PostMapping
    public ResponseEntity<ResponseWrapper> createCourse(@RequestBody CourseDTO courseDTO){ // this is how we capture the dto from postman
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation","Create")
                .body(new ResponseWrapper("new course is created",courseService.createCourse(courseDTO)));

    }
    @DeleteMapping("{id}")
    public ResponseEntity<ResponseWrapper> deleteCourseById(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping({"id"})
    public ResponseEntity<Void> updateCourse(@PathVariable("id") Long courseId, @RequestBody CourseDTO courseDTO)
    {
        courseService.updateCourse(courseId,courseDTO);
        return ResponseEntity.noContent().build();
    }
}
