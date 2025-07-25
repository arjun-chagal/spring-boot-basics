package com.crud.employees.employees_crud.controller;


import com.crud.employees.employees_crud.Entity.Employee;
import com.crud.employees.employees_crud.Service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Rest {

    EmployeeService employeeService;
    ObjectMapper objectMapper; /* object mapper is a default available helper class from Jackson, that helps in creating JsonNodes; Json Nodes contain ObjectNode, ArrayNode, TextNode and so on*/

    //constructor
    public Rest(EmployeeService theEmployeeService, ObjectMapper theObjectMapper){

        employeeService = theEmployeeService;
        objectMapper = theObjectMapper;
    }


    //read(cRud)
    @GetMapping("/employees/{employeeId}")
    public Employee retrieveById(@PathVariable int employeeId){

        Optional<Employee> theEmployee = employeeService.findById(employeeId);

        return theEmployee.orElse(null);
    }

    //read(cRud)
    @GetMapping("/employees")
    public List<Employee> retriveAll(){

        return employeeService.findAll();
    }

    //create (Crud)
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    //update(crUd)
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    //update; but patch update
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload){ /* patchPayload is not of type "Employee", because not all Employee fields like firstName, email, etc would be expected to be filled in patchPayload*/

        Optional<Employee> theEmployee = employeeService.findById(employeeId);
        //Exceptions if id is passed in patchPayload, or if theEmployee is not found
        if(theEmployee.isEmpty()){
            throw new RuntimeException("the employee with the id "+employeeId+" was not found");
        }
        if(patchPayload.containsKey("id")){
            throw new RuntimeException("patch payload CANNOT contain id value");
        }

        Employee tempEmployee = apply(patchPayload, theEmployee.orElse(null));
        Employee dbEmployee = employeeService.save(tempEmployee);

        return dbEmployee;

    }

    //delete(cruD)
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Optional<Employee> theEmployee = employeeService.findById(employeeId);

        if(theEmployee.isEmpty()){
            throw new RuntimeException("You've passed an invalid employee id");
        }
        employeeService.deleteById(employeeId);
        return ("Successfully deleted employee with the id "+employeeId);
    }


    public Employee apply(Map<String, Object> patchPayload, Employee theEmployee){

        //convert patchPayload and theEmployee into object nodes
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        ObjectNode employeeNode = objectMapper.convertValue(theEmployee, ObjectNode.class);
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }



}
