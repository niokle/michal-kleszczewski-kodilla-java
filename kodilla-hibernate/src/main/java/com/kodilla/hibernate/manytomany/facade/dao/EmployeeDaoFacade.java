package com.kodilla.hibernate.manytomany.facade.dao;


import com.kodilla.hibernate.manytomany.Employee;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@NamedQuery(name="Employee.findByName", query="SELECT * FROM employees WHERE firstname LIKE '%' + :ARG + '%'")
//@NamedQuery(name = "Employee.findByName", query = "SELECT * FROM employees WHERE CONCAT(firstname, lastname) LIKE '%' + :ARG + '%'")
public interface EmployeeDaoFacade extends CrudRepository<Employee, Integer> {
    List<Employee> findEmployeeByLastnameContainsOrFirstnameContains(@Param("ARG") String containsChars);
}




