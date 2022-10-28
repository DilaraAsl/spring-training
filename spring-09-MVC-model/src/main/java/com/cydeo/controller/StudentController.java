package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {
    @RequestMapping("/welcome")
    public String homePage(Model model){// we want to execute a method that belongs to the model interface
        model.addAttribute("name","Cydeo");// we will use these attributes in the thymeleaf template
        model.addAttribute("course","MVC");

        String subject="Springboot";

        model.addAttribute("subject",subject);
        int studentId=new Random().nextInt();
        model.addAttribute("id",studentId);

        List<Integer> numbers=new ArrayList<>(Arrays.asList(4,5,6,3,9));

        model.addAttribute("numbers",numbers);
        LocalDate dt= LocalDate.now();
        model.addAttribute("date",dt);

        Student student=new Student(1,"john","doe");
        model.addAttribute("student",student);
        return "student/welcome"; // we no longer add html extention because it is a template file now




    }
}
