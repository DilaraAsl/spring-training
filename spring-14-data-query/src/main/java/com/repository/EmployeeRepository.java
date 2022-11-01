package com.repository;

import com.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //Display all employees with email address ""
    List<Employee> findByEmail(String email);

    //Display all employees with firstname "" and last name "",
    //also show all employees with an email address ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname,String lastname,String email);

    //Display all employees that first name is not ""
    List<Employee> findByFirstNameIsNot(String firstname);

    //Display all employees where last name starts with ""
    List<Employee> findByLastNameStartsWith(String pattern);

    //Display all employees with salaries higher than ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries less than ""
    List<Employee> findBySalaryLessThan(Integer salary);

    // Display all employees that has been hired between "" and ""

    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // Display all employees where salaries are greater and equal to and in order

    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    // display top unique 3 employees that is making less than ""

    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    // Display all employees that do not have email address

    List<Employee> findByEmailIsNull();


    @Query("select e from Employee e ")
    Employee retrieveEmployeeDetail();

    @Query("select e.salary from Employee e where e.email='amcnee1@google.es'")
    Integer retrieveEmployeeSalary(Integer salary);

     //Not equal
    @Query("select e from Employee e where e.salary<>?1") //<> not equal in sql
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    // Like/Contains/StartsWith/EndsWith
    @Query("Select e from Employee e where e.firstName like ?1") // first name starts with
    List<Employee> retrieveEmployeeFirstName(String pattern);

    // show the names who earn a salary Less than
    @Query("select e.firstName from Employee e where e.salary>?1")
    List<String> retrieveEmployeeSalaryLessThan(int salary);

    // Greater than
    @Query("select e from Employee e where e.salary<?1")
    List<Employee> retrieveEmployeeSalaryGreaterThan(int salary);

    // Between
    @Query("select e.lastName from Employee e where e.salary between ?1 and ?2")
    List<String> retrieveEmployeeSalaryBetween(int salaryMin,int salaryMax);

    // hire date before
    @Query("select e from Employee e where e.hireDate>?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);
    //NULL
    @Query("select e from Employee e where e.email is null")
    List<Employee> retrieveEmployeeIsNull();

    //NOT NULL
    @Query("select e from Employee e where e.email is not null")
    List<Employee> retrieveEmployeeIsNotNull();

    // Sorting in ascending order
    @Query("select e from Employee e order by e.salary")
    List<Employee> retrieveEmployeeSalaryAscOrder();


    // Sorting in descending order
    @Query("select e from Employee e order by e.salary desc")
    List<Employee> retrieveEmployeeSalaryDescOrder();

    // Native Query *****
    @Query(value="select * from employees where salary =?1",nativeQuery = true) // sql query starts with value end with nativeQuery=true
    // we are writing everything against to table (table name employees class name Employee )
    List<Employee> retrieveEmployeeDetailBySalary(int salary);

    // Named parameter -not positional
    @Query("select e from Employee e where e.salary=:salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary")int salary);













}
