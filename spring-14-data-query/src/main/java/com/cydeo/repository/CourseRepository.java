package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    // find all courses by category select * from courses where category==""
    // we are returning a list of courses find--select by--where (we don't need from because we are inside course repo)
    List<Course> findByCategory(String category);

    //find all courses by category and order all the entities by name

    List<Course> findByCategoryOrderByName(String category);

    //checks if a course with the supplied name exists

    boolean existsByName(String name);

// returns the count of courses for the given category

    int countByCategory(String category);

    // finds all the courses that start with the given course name string

    List<Course> findByNameStartsWith(String str);

    // find all courses by category and returns a stream

    Stream<Course> streamAllByCategory(String category); // we can use all the stream methods

    @Query("select c from Course c where c.category=:category and c.rating>:rating")
    List<Course> retrieveAllByCategoryAndRatingGreaterThan(@Param("category") String category,@Param("rating") int rating);
}
