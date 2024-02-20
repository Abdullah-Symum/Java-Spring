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
    private Coach myCoach , anotherCoach;
    //define a constructor for dependency injection
    @Autowired
    public DemoController (
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theanotherCoach){
        System.out.println("In Constructor"+ getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theanotherCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
    @GetMapping("/check")
    public String check(){
        return "Comparing Beans: myCoach==anotherCoach, " + (myCoach==anotherCoach);
    }
    // Check to see if this is the same bean, Singleton : True
    //                                        Prototype : False
}
