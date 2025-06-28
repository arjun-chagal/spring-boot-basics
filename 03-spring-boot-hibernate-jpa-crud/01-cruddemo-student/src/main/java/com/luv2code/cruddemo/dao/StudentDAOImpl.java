package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
    public Student findById(int id){
        return entityManager.find(Student.class, id);
    }


    @Override
    public List<Student> findAll(){
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        /*
        can also write "TypedQuery<Student> theQuery = entityManager.createQuery("SELECT s FROM Student s", Student.class);"
        the query is in JPQL, which writes on entity objects("Student" is the entity class). "s" is entity object of "Student" entity
         */
        return theQuery.getResultList();
    }


    @Override
    public List<Student> findByLastName(String lName) {
        TypedQuery<Student> tempQuery = entityManager.createQuery(
            "SELECT s FROM Student s WHERE s.lastName = :lastN", Student.class);
        tempQuery.setParameter("lastN", lName);
        return tempQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student){
        entityManager.merge(student);
    }
}
