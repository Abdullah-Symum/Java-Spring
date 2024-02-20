package com.symum.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // Add an init-binder to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true); // defined in the spring API - removes whitespace - leading and trailing
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showFrom(Model model){
        model.addAttribute("customer" , new Customer());

        return "customer-form";
    }

    // BindingResult holds the validation result
    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult){

        System.out.println("Last name: |"+ customer.getLastName()+"|");

        System.out.println("Binding results: "+bindingResult.toString());

        if (bindingResult.hasErrors()){
         return "customer-form";
        }
        else{
            return "customer-confirmation";
        }
    }

}
