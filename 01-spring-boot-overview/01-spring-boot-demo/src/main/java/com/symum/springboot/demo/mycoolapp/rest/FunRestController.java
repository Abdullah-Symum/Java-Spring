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

}
