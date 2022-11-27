package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("courses/api/v1") // v1->version 1 best practice to name your end points
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
   // @ResponseBody // you are not working with thymeleaf or view anymore-- instead of adding @ResponseBody to each method
    // controller and responsebody combined @RestController


    public List<CourseDTO> getAllCourses(){

        return courseService.getCourses();
    }
    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long courseId){
        return courseService.getCourseById(courseId);

    }

    @GetMapping("category/{category}")
    public List<CourseDTO> getCourseByCategory(@PathVariable("category") String courseCategory){
        return courseService.getCoursesByCategory(courseCategory);
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO){ // this is how we capture the dto from postman
        return courseService.createCourse(courseDTO);

    }
    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") long courseId,@RequestBody CourseDTO courseDTO){
        courseService.updateCourse(courseId,courseDTO);
    }
    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable("id") long courseId){
        courseService.deleteCourseById(courseId);
    }
}
