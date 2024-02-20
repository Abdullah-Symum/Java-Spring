package com.symum.demo.rest;

import com.symum.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;
    // Define @PostConstructor to load the student data... it will be called only once.
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Pornima","Sithi"));
        theStudents.add(new Student("Sabbnoor","Patha"));
        theStudents.add(new Student("Diti","Das"));
    }
    // Define endpoint for "/students" - return a list of student
    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    // Define endpoint or "/student/{studentId" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // Just Index into the list

        // Check the studentId list
        if ((studentId>= theStudents.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return theStudents.get(studentId);
    }
}
