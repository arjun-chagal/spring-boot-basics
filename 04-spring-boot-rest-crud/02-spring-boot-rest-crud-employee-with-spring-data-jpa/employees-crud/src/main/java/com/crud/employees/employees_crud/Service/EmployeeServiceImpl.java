package com.crud.employees.employees_crud.Service;

import com.crud.employees.employees_crud.DAO.EmployeeRepository;
import com.crud.employees.employees_crud.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    @Transactional
    /* Need to use Optional<> and not "Employee";Optional<> has 2 states, when Employee with id exists, it returns that object. If it doesnt, it returns Optional.empty() - not null;  which handles exceptions */
    public Optional<Employee> findById(int id) {

        Optional<Employee> result = employeeRepository.findById(id);
        Optional<Employee> theEmployee;
        if(result.isPresent()){
            theEmployee = Optional.of(result.get());
        }
        else{
            throw new RuntimeException("The employee with the id: "+id+" does not exist");
        }

        return theEmployee;
    }

    @Override
    //@Transactional
    /* No need to add @Transactional since JpaRepository already has this inbuilt functionality*/
    public List<Employee> findAll(){

        return employeeRepository.findAll();
    }

    @Override
    //@Transactional
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    //@Transactional
    public void deleteById(int id) {

        employeeRepository.deleteById(id);
    }
}
