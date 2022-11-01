package com.bootstrap;

import com.entity.Book;
import com.entity.Car;
import com.entity.Department;
import com.entity.Employee;
import com.enums.Gender;
import com.repository.BookRepository;
import com.repository.CarRepository;
import com.repository.DepartmentRepository;
import com.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component // this class has a dependecy
public class DataGenerator implements CommandLineRunner { // we want the information to be loaded when the application runs
    private  final CarRepository carRepository; // we need to inject CarRepository obj
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final BookRepository bookRepository;

    public DataGenerator(CarRepository carRepository, EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, BookRepository bookRepository) {
        this.carRepository = carRepository;
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Car c1=new Car("BMW","M3");
        Car c2=new Car("Honda","Civic");
        Car c3=new Car("Toyota","Corolla");
// to add car objects to the database we need to inject CarRepository to call the methods
        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);
        List<Employee> employeeList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();
        List<Book> bookList = new ArrayList<>();

        Employee e1 = new Employee("Berrie", "Manueau", "bmanueau0@dion.ne.jp", LocalDate.of(2006,04,20), Gender.F, 2500);
        Employee e2 = new Employee("Aeriell", "McNee", "amcnee1@google.es", LocalDate.of(2009,01,26), Gender.F, 2500);
        Employee e3 = new Employee("Sydney", "Symonds", "ssymonds2@hhs.gov", LocalDate.of(2010,05,17), Gender.F, 2500);
        Employee e4 = new Employee("Avrom", "Rowantree", null, LocalDate.of(2014,03,02), Gender.M, 2500);
        Employee e5 = new Employee("Feliks", "Morffew", "fmorffew4@a8.net", LocalDate.of(2003,01,14), Gender.M, 2500);
//
//        employeeRepository.save(e1);
//        employeeRepository.save(e2);
//        employeeRepository.save(e3);
//        employeeRepository.save(e4);
//        employeeRepository.save(e5);


        Department d1 = new Department("Sports","Outdoors");
        Department d2 = new Department("Tools","Hardware");
        Department d3 = new Department("Clothing","Home");
        Department d4 = new Department("Phones & Tablets","Electronics");
        Department d5 = new Department("Computers","Electronics");


//       departmentRepository.save(d1);
//       departmentRepository.save(d2);
//       departmentRepository.save(d3);
//       departmentRepository.save(d4);
//       departmentRepository.save(d5);


        employeeList.addAll(Arrays.asList(e1,e2,e3,e4,e5));
        departmentList.addAll(Arrays.asList(d1,d2,d3,d4,d5));

        employeeRepository.saveAll(employeeList);
        departmentRepository.saveAll(departmentList);

       Book b1= new Book("Emily Dickinson","Poems",LocalDate.of(1925,06,04));
       Book b2= new Book("Arthur Miller","Death of a Salesman",LocalDate.of(1965,1,13));
       Book b3= new Book("John Steinbeck","Of mice and men",LocalDate.of(1971,7,24));

       bookList.addAll(Arrays.asList(b1,b2,b3));
       bookRepository.saveAll(bookList);

    }





}
