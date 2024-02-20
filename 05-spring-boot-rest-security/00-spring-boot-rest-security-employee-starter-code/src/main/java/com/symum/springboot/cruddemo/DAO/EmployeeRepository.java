package com.symum.springboot.cruddemo.DAO;

import com.symum.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Integer>{
    // By extending JPARepository we can avoid the boiler code of the dao and dao implementation.

}
