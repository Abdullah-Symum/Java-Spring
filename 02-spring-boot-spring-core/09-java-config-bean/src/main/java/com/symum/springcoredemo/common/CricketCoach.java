package com.symum.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
// To declare prototype scope.
public class CricketCoach implements Coach{
    public CricketCoach(){
        System.out.println("In Constructor"+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice Fast Bowling";
    }
}
