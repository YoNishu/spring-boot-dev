package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

//    @Autowired
//    public DemoController(Coach theCoach) {
//        myCoach=theCoach;
//    }

    @Autowired
    public void setCoach(@Qualifier("footballCoach") Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/getdailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
