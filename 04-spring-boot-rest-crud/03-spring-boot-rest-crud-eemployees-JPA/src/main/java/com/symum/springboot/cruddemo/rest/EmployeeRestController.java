package com.symum.springboot.cruddemo.rest;

import com.symum.springboot.cruddemo.entity.Employee;
import com.symum.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    // Inject employeeService
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }
    // Expose the "/Employees" and return a list of Employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    // Add mapping to get "/employees/{employeeId}"
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id is not found - " +employeeId);
        }
        return theEmployee;
    }

    // Add mapping for POST /employees - add new employees
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // ALso just in case they pass an id in JSON, Set id to 0.
        theEmployee.setId(0);

        // This is to force a save of new item, instead of update.
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // Add mapping for the Put request
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // Add mapping for delete.
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee (@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        // Throw an exception
        if (tempEmployee==null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id - "+employeeId;
    }
}

