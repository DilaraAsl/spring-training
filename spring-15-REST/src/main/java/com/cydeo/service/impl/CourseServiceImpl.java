package com.cydeo.service.impl;

import com.cydeo.dto.CourseDTO;
import com.cydeo.entity.Course;
import com.cydeo.repository.CourseRepository;
import com.cydeo.service.CourseService;
import com.cydeo.util.MapperUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final MapperUtil mapper;

    public CourseServiceImpl(CourseRepository courseRepository, MapperUtil mapper) {
        this.courseRepository = courseRepository;
        this.mapper = mapper;
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
         courseRepository.save(mapper.convert(courseDTO,new Course()));
        return courseDTO;
    }

    @Override
    public CourseDTO getCourseById(long courseId) {
        Course course=courseRepository.findById(courseId).get();// optional
        return mapper.convert(course,new CourseDTO());
    }

    @Override
    public List<CourseDTO> getCoursesByCategory(String category) {
        return courseRepository.findAllByCategory(category).stream().map(course -> mapper.convert(course,new CourseDTO())).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourses() {
        return courseRepository.findAll().stream().map(course -> mapper.convert(course,new CourseDTO())).collect(Collectors.toList());
    }

    @Override
    public void updateCourse(Long courseId, CourseDTO courseDTO) {

     Course course=mapper.convert(courseDTO,new Course());
     courseRepository.findById(courseId).ifPresent(dbCourse->{
         dbCourse.setName(course.getName());
         dbCourse.setCategory(course.getCategory());
         dbCourse.setDescription(course.getDescription());
         dbCourse.setRating(course.getRating());
         courseRepository.save(dbCourse);
     });

    }

    @Override
    public void deleteCourseById(long courseId) {
       courseRepository.deleteById(courseId);

    }

    @Override
    public void deleteCourses() {
        courseRepository.deleteAll();

    }
}
