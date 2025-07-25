package com.crud.employees.employees_crud;

import com.crud.employees.employees_crud.DAO.EmployeeDAOImpl;
import com.crud.employees.employees_crud.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@SpringBootApplication
public class EmployeesCrudApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeesCrudApplication.class, args);
	}
}
