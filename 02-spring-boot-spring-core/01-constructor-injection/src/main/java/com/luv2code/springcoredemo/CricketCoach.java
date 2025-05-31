package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

@Component
class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return "practise bowling for 30 minutes";
    }
}