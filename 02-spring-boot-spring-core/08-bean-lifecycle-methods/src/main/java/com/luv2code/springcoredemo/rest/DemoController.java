package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("badmintonCoach") Coach theCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    @PostConstruct
    public void doMyStartUpStuff () {
        System.out.println("In doMyStartUpStuff: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanUpStuff () {
        System.out.println("In doMyCleanUpStuff: " + getClass().getSimpleName());
    }

    @GetMapping("/getdailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
