package com.crud.employees.employees_crud.Service;

import com.crud.employees.employees_crud.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> findById(int id);

    List<Employee> findAll();

    Employee save(Employee theEmployee);

    void deleteById(int id);

}
