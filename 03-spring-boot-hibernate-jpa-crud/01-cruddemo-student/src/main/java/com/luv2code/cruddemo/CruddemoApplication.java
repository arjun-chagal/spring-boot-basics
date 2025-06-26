package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple student objects
		Student temp1student = new Student("Arjun", "Chagal", "connie@gmail.com");
		Student temp2student = new Student("Manas", "Khan", "manas@gmail.com");
		Student temp3student = new Student("Oliver", "CLive", "oliver@gmail.com");

		//save these objs in the DB

		studentDAO.save(temp1student);
		studentDAO.save(temp2student);
		studentDAO.save(temp3student);
	}

	/*public void createStudent(StudentDAO studentDAO){
		//create a new student obj
		Student tempStudent = new Student("Cake", "Paul", "cakepaul123@gmail.com");

		//save the student obj
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. The generated id is: "+tempStudent.getId());
	}
*/
}
