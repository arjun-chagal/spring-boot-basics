package com.crud.employees.employees_crud.DAO;

import com.crud.employees.employees_crud.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
