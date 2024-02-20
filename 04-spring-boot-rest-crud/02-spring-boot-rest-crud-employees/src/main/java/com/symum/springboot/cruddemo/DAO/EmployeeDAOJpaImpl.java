package com.symum.springboot.cruddemo.DAO;

import ch.qos.logback.core.model.conditional.ElseModel;
import com.symum.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    // Define field for entity manager.
    private EntityManager entityManager;

    // Setup constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // Create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery(
                                      "FROM Employee", Employee.class);

        // Execute Query and get result
        List<Employee> employees = theQuery.getResultList();

        // Return the results

        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // Get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
        // Return Employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // Save employee
        Employee dbEmployee = entityManager.merge(theEmployee);
        // The merge method works here if the id==0 it will insert or save the id otherwise it will update the id.

        // Return Employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // Find employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);
        // Remove the id
        entityManager.remove(theEmployee);
    }
}
