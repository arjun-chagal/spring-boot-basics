package com.luv2code.springcoredemo.common;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
 public class FootballCoach implements Coach{

    FootballCoach(){
        System.out.println("In constructor football coach");
    }
     public String getDailyWorkout() {
         return "foul messi";
     }
}
