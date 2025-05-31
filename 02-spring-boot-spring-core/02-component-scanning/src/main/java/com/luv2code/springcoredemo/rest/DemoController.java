package com.luv2code.springcoredemo.rest;


import com.luv2code.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach myCoach;
   @Autowired
    public DemoController(Coach coach){
        myCoach = coach;
    }
@GetMapping("/dailyworkout")
    public String dailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/")
    String homePage(){
       return "this is the home page";
    }
}
