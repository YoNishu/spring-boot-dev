package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Do 1 hour of penalty practice :-)";
    }
}
