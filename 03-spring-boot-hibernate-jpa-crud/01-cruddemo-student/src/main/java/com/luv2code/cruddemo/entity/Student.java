package com.luv2code.cruddemo.entity;


import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {


    //add columns


    //id and generated value annots are only for primary keys
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
    public Student(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }



//if a class doesnt have any xplicitely defined constructor, java provides a no arg constructor for free.
//but if you explicitely define a constructor, java does not provide that default no arg constructor

    //add a no arg constructor
    public Student(){

    }


    //add getters and setters
    public int getId(){
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
