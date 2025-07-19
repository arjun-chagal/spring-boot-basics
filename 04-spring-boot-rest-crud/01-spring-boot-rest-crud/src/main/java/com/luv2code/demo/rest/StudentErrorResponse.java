package com.luv2code.demo.rest;



//this is the POJO that handles exceptions
public class StudentErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

    public int getStatus(){
        return status;
    }

    public String getMessage(){
        return message;
    }

    public long getTimeStamp(){
        return timeStamp;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setTimeStamp(long timeStamp){
        this.timeStamp = timeStamp;
    }

    public StudentErrorResponse(){

    }

    public StudentErrorResponse(int status, String message, long timeStamp){
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

}
