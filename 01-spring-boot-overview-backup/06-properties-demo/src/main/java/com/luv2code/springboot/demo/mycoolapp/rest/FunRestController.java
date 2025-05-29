package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

//expose a new endpoint called "workout"


    @GetMapping("/surfing")
    public String getGoodAtSurfing(){
        return "I want to get good at surfing!!";
    }
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }



    //injecting values from application.properties folder
    @Value("${driver.name}")
    private String driverName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Driver name: " +driverName + " and the team name: " +teamName;
    }



}