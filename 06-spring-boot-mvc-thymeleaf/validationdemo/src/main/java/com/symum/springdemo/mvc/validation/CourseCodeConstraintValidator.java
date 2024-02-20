package com.symum.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    // Contain business rules for validation.
    private String coursePrefix;
    @Override
    public void initialize(CourseCode courseCode){
        coursePrefix=courseCode.value(); // assign the value passed in form our validation
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        
//        boolean result;
//        if (s != null) {
//            result = s.startsWith(coursePrefix);
//        }
//        else{
//            result = true;
//        }
        // Adding a null check to avoid NullPointerException
        if (s == null) {
            return false;
        }

        boolean result = s.startsWith(coursePrefix);

        return result;
    }
}
