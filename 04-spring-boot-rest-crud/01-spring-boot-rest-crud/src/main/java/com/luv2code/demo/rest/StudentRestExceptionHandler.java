package com.luv2code.demo.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;




//Controller advice(CA) will be in between the REST Client and REST service; earlier code had exception handling in REST service,
//which made exception handler classes local. Putting exc handler classes in CA means these classes are global exception handlers
@ControllerAdvice
public class StudentRestExceptionHandler {

    //exception handling for index out of bounds exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> displayError(StudentNotFoundException exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleGenericExceptions(Exception exc){

        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}


