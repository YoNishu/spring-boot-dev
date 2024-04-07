package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return null;
    }
}
