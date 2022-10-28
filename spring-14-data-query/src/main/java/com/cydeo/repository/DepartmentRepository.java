package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> { // department is the id which is String
    //display all the departments in the furniture department
    List<Department> findByDepartment(String department);

    //display all the departments in the health division

    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    // Display all departments with division name ends with "ics"

    List<Department> findByDivisionEndsWith(String pattern);

    // Display top 3 departments with division name includes "hea" without duplicates

    List<Department> findDistinctTop3ByDivisionContaining(String pattern);

    //native query
   // @Query(value="",nativeQuery = true)

    @Query(value="select d from department where d.division in ?1",nativeQuery = true)
    List<Department> retrieveDepartmentDivision(List<String> division); // pass everything as a list instead of multiple parameters
}
