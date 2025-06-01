package com.luv2code.springcoredemo.rest;


import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;
   @Autowired
   DemoController(@Qualifier("footballCoach")Coach theCoach, @Qualifier("footballCoach") Coach theAnotherCoach){
       System.out.println("This is the class bean "+getClass().getSimpleName());

       anotherCoach = theAnotherCoach;
       myCoach = theCoach;
   }


@GetMapping("/dailyworkout")
    public String dailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/")
    String homePage(){
       return "this is the home page";
    }

    @GetMapping("/check")
    public String checkBeanScope(){
       return ("Two private fields theCoach and theAnotherCoach are the from the same bean instance, "+(anotherCoach == myCoach));
    }
}
