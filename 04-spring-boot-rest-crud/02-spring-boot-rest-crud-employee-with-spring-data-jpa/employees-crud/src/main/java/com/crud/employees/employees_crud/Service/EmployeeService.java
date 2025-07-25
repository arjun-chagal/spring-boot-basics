package com.crud.employees.employees_crud.Service;

import com.crud.employees.employees_crud.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findById(int id);

    List<Employee> findAll();

    Employee save(Employee theEmployee);

    void deleteById(int id);

}
