package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MentorController {
    @RequestMapping("mentor")
    public String mentorPage(Model model){
        List<Mentor> mentorList=new ArrayList<>(Arrays.asList(new Mentor("Mike","Smith",45, Gender.MALE),
                new Mentor("Tom","Hanks",65, Gender.MALE),
                new Mentor("Amy","Bryan",25, Gender.FEMALE)));
        model.addAttribute("mentorList",mentorList);
        return "mentor/mentor";
    }

}
