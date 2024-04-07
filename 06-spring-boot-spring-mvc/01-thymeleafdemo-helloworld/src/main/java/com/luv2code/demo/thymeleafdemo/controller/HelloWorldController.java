package com.luv2code.demo.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShout(HttpServletRequest request, Model theModel) {

        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();

        String result = "Yo!!" + theName;

        theModel.addAttribute("message", result);

        return "helloworld";
    }

    @GetMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model theModel) {

        theName = theName.toUpperCase();

        String result = "Hello to my friend from v3!! " + theName;

        theModel.addAttribute("message", result);

        return "helloworld";
    }
}
