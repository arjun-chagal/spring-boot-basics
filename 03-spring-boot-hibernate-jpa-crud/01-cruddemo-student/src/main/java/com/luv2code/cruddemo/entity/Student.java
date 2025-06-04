package com.luv2code.cruddemo.entity;


import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {


    //add columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;


    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;



    //add arg constructor
    Student(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }




    //add a no arg constructor
    public Student(){
        System.out.println("somehing");
    }


    //add getters and setters
    int getId(){
        return id;
    }

    void setId(int id){
        this.id = id;
    }
    String getFirstName(){
        return firstName;
    }

    void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
