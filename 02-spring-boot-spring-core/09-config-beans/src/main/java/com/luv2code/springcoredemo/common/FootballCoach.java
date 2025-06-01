package com.luv2code.springcoredemo.common;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
 public class FootballCoach implements Coach{

    FootballCoach(){
        System.out.println("In constructor football coach");
    }
     public String getDailyWorkout() {
         return "foul messi";
     }
}
