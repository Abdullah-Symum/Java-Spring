package com.symum.springboot.cruddemo.DAO;

import com.symum.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// To change the resource path from employee to members, by default the jpa repo will
// convert the path name to its plural form but due to language barrier it can not
// change all the thing into its plural form so the below annotation @RepositoryRestResource will give us a custom path.
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository <Employee, Integer>{
    // By extending JPARepository we can avoid the boiler code of the dao and dao implementation.

}
