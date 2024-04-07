package com.devspringboot.myfirstapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coach;

    @Value("${team.name}")
    private String team;

    @GetMapping("/")
    public String sayHello(){
        return coach;
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return coach+": Do daily workout mf!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return coach+": You'll have fortune equal to mine.";
    }
}
