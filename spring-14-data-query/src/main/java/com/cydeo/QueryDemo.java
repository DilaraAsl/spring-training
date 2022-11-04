package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;
    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        System.out.println("findByCountry:"+regionRepository.findByCountry("Canada"));
//        System.out.println("findByCountryContaining:"+regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContaining:"+regionRepository.findTop2ByCountry("United States"));
        System.out.println("findByCountryContaining:"+regionRepository.findByCountryContainsOrderByRegion("United States"));
        System.out.println("-------------DEPARTMENTS------------------------------------");
        System.out.println(departmentRepository.findByDepartment("Furniture"));
        System.out.println(departmentRepository.findByDivision("Health"));
        System.out.println(departmentRepository.findByDivisionEndsWith("ics"));
        System.out.println("**********************");
        System.out.println(departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));
        System.out.println("**********************");
        //System.out.println(employeeRepository.findByEmail(@*.com"));


    }
}
