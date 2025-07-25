package com.crud.employees.employees_crud.DAO;

import com.crud.employees.employees_crud.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    //create (or update), retrieve,and delete one or multiple employees
    Employee save(Employee theEmployee);

    Employee findById(int id);

    void deleteById(int id);

}
