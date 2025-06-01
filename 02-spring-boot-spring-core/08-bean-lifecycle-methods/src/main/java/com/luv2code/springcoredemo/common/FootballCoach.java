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


     //for init and destroy hooks, you cant use string return type methods, as you will not
     // be able to see the output. use public void methods, containing a println statement,
     // so that you can see the output in your console.
     @PostConstruct
    public void postConstructMethod(){
      System.out.println("Logic for after bean initialisation in class "+getClass().getSimpleName());
     }
//below Predestroy implementation is not visible in console; but the above postconstruct method is.
     @PreDestroy
    public String preDestroy(){
        return ("logic for before destroying bean instance in class "+getClass().getSimpleName());
     }

}
