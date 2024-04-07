package com.luv2code.demo.thymeleafdemo.controller;

import com.luv2code.demo.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> favoriteLanguages;

    @Value("${systems}")
    private List<String> favoriteSystems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        theModel.addAttribute("countries", countries);

        theModel.addAttribute("languages", favoriteLanguages);

        theModel.addAttribute("systems", favoriteSystems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        System.out.println("Student Name: " + theStudent.getFirstName() + " " + theStudent.getLastName());
        System.out.println("Country: " + theStudent.getCountry());
        System.out.println("Favorite Progarmming Language: " + theStudent.getFavoriteLanguage());
        System.out.print("Favorite Operating System: ");

        int systemArraySize = theStudent.getFavoriteSystem().size();
        int iterator = 0;

        for(String tempSystem: theStudent.getFavoriteSystem()) {
            if(iterator != systemArraySize-1)
                System.out.print(tempSystem + ", ");
            else
                System.out.println(tempSystem);
            iterator++;
        }

        return "student-confirmation";
    }
}
