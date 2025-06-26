package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


//studentDAO is used for interacting with the entity manager.
//
@Repository
public class StudentDAOImpl implements StudentDAO{

    //define a private field entityManager
    private EntityManager entityManager;


    //inject entityManager by constructor injection
    @Autowired
    StudentDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    //save a java object item using the entityManager

    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

    // find a student object
    @Override
    public void findById(Student theStudent){
        entityManager.find(Student.class, theStudent);
    }
}
