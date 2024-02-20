package com.symum.code.cruddemo;

import com.symum.code.cruddemo.dao.StudentDAO;
import com.symum.code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	// CommandLineRunner is from spring boot framework and will be executed after spring bean have been loaded.
	// And we can use this in commandLineRunner method.
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudent(studentDAO);
		};
		// runner-> is a java lambda expression shortcut for java commandLineRunner interface
		// for custom code.
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all the Students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted Row count: " +numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting the student id: "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Retrieve student based on the id: primary key
		int  studentId = 1;
		System.out.println("Getting student id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		// Change the first name to Scooby
		System.out.println("Updating Student...");
		myStudent.setFirstName("Scooby");

		// Update the student
		studentDAO.update(myStudent);

		// Display the updated student
		System.out.println("Uploading student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// Get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Hoe");
		// Display the Students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// Get a list of students
		List<Student> theStudents = studentDAO.findAll();
		// Display the list of student
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// Create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy", "Hoe", "daffy@`gmail.com");

		// Save the Student
		System.out.println("Save the student...");
		studentDAO.save(tempStudent);

		// Display id of the saved student
		int theId= tempStudent.getId();
		System.out.println("Saved student.Generate id: " + theId);

		// Retrieve Student based on the id: Primary Key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// Display Student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO){
		// Create Multiple Students
		System.out.println("Creating 3 new student...");
		Student tempStudent1 = new Student("Mary", "Hugson", "mary@gmail.com");
		Student tempStudent2 = new Student("John", "Doe", "john@gmail.com");
		Student tempStudent3 = new Student("Bonita", "Bum", "bum@gmail.com");
		// Save the Students Objects
		System.out.println("Saving the Student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}
	private void createStudent(StudentDAO studentDAO) {
		// Create the Student object
		System.out.println("Creating new student...");
		Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");

		// save the student object
		System.out.println("Saving the Student...");
		studentDAO.save(tempStudent);

		// display the saved account
		System.out.println("Saved student. Generate id: "+ tempStudent.getId());
	}
}
