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

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> displayError(StudentNotFoundException exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }


}
