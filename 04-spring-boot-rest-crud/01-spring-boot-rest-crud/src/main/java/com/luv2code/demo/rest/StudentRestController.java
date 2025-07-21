package com.luv2code.demo.rest;


import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;
    //postconstruct and other lifecycle bean annotations
    // are only valid when theyre in the bean body, and not in any methods in the bean body
    @PostConstruct
    public void loadStudents(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Arjun", "Chagal"));
        theStudents.add(new Student("Max", "Verstappen"));
        theStudents.add(new Student("Pewis", "Pamilton"));
        theStudents.add(new Student("Ayrton", "Senna"));
    }


    @GetMapping("/students/{studentId}")
    public Student returnStudent(@PathVariable int studentId){
        if(studentId > theStudents.size() || studentId < 0){


            throw new StudentNotFoundException("error in finding student of id: "+studentId);
        }
        return theStudents.get(studentId);
    }


//can also write another custom exception handler to handle bad requests;
// example, when the studentId is inputed as a string instead of a number


}
