package com.symum.springcoredemo.rest;

import com.symum.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for dependency
    private Coach myCoach;
    //    //define a constructor for dependency injection
    //    @Autowired
    //    public DemoController(Coach theCoach){
    //        myCoach = theCoach;
    //    }

    //this is field injection.
    //@Autowired
    //private Coach myCoach;
    //no need for constructor or setters
    @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }
    // We cn use any method instead of srt method, to inject the name if we use @Autowired.
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
