package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
 public class FootballCoach implements Coach{
     public String getDailyWorkout() {
         return "run 10km in the game";
     }
}
