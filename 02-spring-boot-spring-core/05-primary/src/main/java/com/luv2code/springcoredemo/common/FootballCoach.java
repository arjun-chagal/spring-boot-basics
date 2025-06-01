package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
 public class FootballCoach implements Coach{
     public String getDailyWorkout() {
         return "foul messi";
     }
}
