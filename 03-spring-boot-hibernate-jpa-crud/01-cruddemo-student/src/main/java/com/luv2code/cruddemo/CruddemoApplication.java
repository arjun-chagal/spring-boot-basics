package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{

			/*printing the entire table
			for(Student stud :readAll(studentDAO)){
				System.out.println(stud);
			}*/

			/*retrieving student from the inputted last name
			for(Student stud: getStudentFromLastName(studentDAO, "Chagal")){
				System.out.println(stud);
			}*/

			updateStudent(studentDAO, 4);


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



	public void readStudent(StudentDAO studentDAO){
		//create student
		Student tempStudent = new Student("Reed", "Student", "reedstudent@gmail.com");
		studentDAO.save(tempStudent);
		//find the id
		int theId= tempStudent.getId();
		Student stud = studentDAO.findById(theId);

		//show the id
		System.out.println("Found the student. The ID is: "+stud.getId());

		//show the entire student obj
		System.out.println("The student first name is: "+stud.getFirstName()+" , the last name is: "+stud.getLastName()+" ,and the email is "+stud.getEmail());
	}

	public void createStudent(StudentDAO studentDAO){
		//create a new student obj
		Student tempStudent = new Student("Cake", "Paul", "cakepaul123@gmail.com");

		//save the student obj
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. The generated id is: "+tempStudent.getId());
	}
	List<Student> readAll(StudentDAO studentDAO){
		return studentDAO.findAll();
	}

	List<Student> getStudentFromLastName(StudentDAO std, String lName){
		return std.findByLastName(lName);
	}

	void updateStudent(StudentDAO studentDAO, int id){

		//find the student obj with the inputted id
		System.out.println("finding the student object with the id: "+id);
		Student tempStud = studentDAO.findById(id);
		System.out.println("The unchanged student object is: "+tempStud);

		//set the new value; this change is only reflected in the java application memory, and does NOT affect the sql table
		System.out.println("Updating the first name to: Pinnu");
		tempStud.setFirstName("Pinnu");

		//update the value to the table
		System.out.println("Updating this into the table");
		studentDAO.update(tempStud);

		//displaying
		System.out.println("The updated student object is: "+tempStud);

	}


}








































