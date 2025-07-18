package com.luv2code.demo.rest;


import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        theStudents.add(new Student("Oscar", "Piastri"));
        theStudents.add(new Student("Ayrton", "Senna"));
    }


    @GetMapping("/students/{studentId}")
    public Student returnStudent(@PathVariable int studentId){
        return theStudents.get(studentId);
    }



}
