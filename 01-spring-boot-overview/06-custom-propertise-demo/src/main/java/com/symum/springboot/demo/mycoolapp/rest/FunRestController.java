package com.symum.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@GetMapping annotation in Spring is a powerful for building RESTful web services.
//        It maps HTTP GET requests to a specific handler method in Spring controllers.

@RestController  // Set up rest controller
public class FunRestController {
    // Expose "/" that return "hello World!"
    // Add new custom properties for the Coach and Team.
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;
    // Add new endpoints for the team and coach name:
    @GetMapping("/team-info")
    public String getTeamInfo(){
        return "Coach Name: " + coachName+ "  " + "Team Name: " + teamName;
    }
    @GetMapping("/")  // Handle HTTP get requests
    public String sayHello(){
        return "Hello World!";
    }
    //expose a new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }
    // expose a new endpoint for fortune.
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is Your Lucky Day";
    }


}
