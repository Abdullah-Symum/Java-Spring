package com.symum.springdemo.mvc;


import com.symum.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName = " ";

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to o")
    @Max(value = 10, message = "must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 chars/digits")
    private String postalCode;

    @CourseCode
    private String courseCode;

}
