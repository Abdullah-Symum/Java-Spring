package com.symum.springboot.cruddemo.DAO;

import com.symum.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);
    Employee save (Employee theEmployee);
    void deleteById(int theId);
}
