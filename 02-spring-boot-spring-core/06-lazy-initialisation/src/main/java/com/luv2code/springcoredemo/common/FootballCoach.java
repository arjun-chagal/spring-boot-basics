package com.luv2code.springcoredemo.common;

//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
 public class FootballCoach implements Coach{

    FootballCoach(){
        System.out.println("In constructor football coach");
    }
     public String getDailyWorkout() {
         return "foul messi";
     }
}
