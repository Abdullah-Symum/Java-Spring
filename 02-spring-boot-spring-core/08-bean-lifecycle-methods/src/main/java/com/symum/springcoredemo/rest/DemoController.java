package com.symum.springcoredemo.rest;

import com.symum.springcoredemo.common.Coach;
import com.symum.springcoredemo.common.TennisCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for dependency
    private Coach myCoach;
    //define a constructor for dependency injection
    @Autowired
    public DemoController (@Qualifier("cricketCoach") Coach theCoach){
        myCoach = theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
