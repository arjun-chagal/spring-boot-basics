package com.luv2code.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    CricketCoach(){
        System.out.println("In constructor cricket coach");
    }

    @Override
   public String getDailyWorkout(){
        return "practice fast bowling for an hour!!!";
    }
}
