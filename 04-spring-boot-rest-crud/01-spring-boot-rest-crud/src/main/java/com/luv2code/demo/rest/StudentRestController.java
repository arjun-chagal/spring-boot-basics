package com.luv2code.demo.rest;


import com.luv2code.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> returnStudent(){
        //hardcoded adding students
        //will directly connect to the DB later
        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Arjun", "Chagal"));
        theStudents.add(new Student("Max", "Verstappen"));
        theStudents.add(new Student("Oscar", "Piastri"));
        theStudents.add(new Student("Ayrton", "Senna"));

        return theStudents;

    }



}
