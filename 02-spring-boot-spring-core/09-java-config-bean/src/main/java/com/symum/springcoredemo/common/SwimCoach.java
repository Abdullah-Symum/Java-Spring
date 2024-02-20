package com.symum.springcoredemo.common;
// We are not going @component annotation here as it is for custom bean creation.

public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1000m as a warmup";
    }
}
