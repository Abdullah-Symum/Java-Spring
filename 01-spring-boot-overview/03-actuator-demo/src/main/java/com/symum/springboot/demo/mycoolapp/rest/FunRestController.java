package com.symum.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Set up rest controller
public class FunRestController {
    // expose "/" that return "hello World!"
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
