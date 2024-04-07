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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			retrieveStudent(studentDAO);
//			queryTable(studentDAO);
//			queryTableByLastName(studentDAO);
//			updateTable(studentDAO);
//			deleteStudent(studentDAO);
//			delete(studentDAO);
		};

	}

	private void delete(StudentDAO studentDAO) {
		int numRowsDeleted = studentDAO.delete();
		System.out.println("Number of rows deleted: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 4;
		System.out.println("Deleting Student with id: " + id);
		studentDAO.deleteStudent(id);
	}

	private void updateTable(StudentDAO studentDAO) {
		int id = 2;
		System.out.println("Getting student with id:" + id);
		Student myStudent = studentDAO.findById(id);

		System.out.println("Updating the First Name to 'Kashu'");
		myStudent.setFirstName("Kashu");
		studentDAO.updateStudent(myStudent);

		System.out.println("Now student is: " + myStudent);
	}

	private void queryTableByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Gangajaliya");
		for(Student curStudent : theStudents){
			System.out.println(curStudent);
		}
	}

	private void queryTable(StudentDAO studentDAO) {
		List<Student> allStudents = studentDAO.findAll();
		for(Student curStudent : allStudents){
			System.out.println(curStudent);
		}
	}

	private void retrieveStudent(StudentDAO studentDAO) {
		System.out.println("Creating a student object...");
		Student tempStudent = new Student("Nishith","Gangajaliya","nishith@icloud.com");

		System.out.println("Saving the student object...");
		studentDAO.save(tempStudent);

		System.out.println("Student created in table with id: " + tempStudent.getId());

		System.out.println("Retrieving the student object...");
		System.out.println("The student is: " +  studentDAO.findById(tempStudent.getId()));
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 new student objects...");
		Student tempStudent1 = new Student("Nishith","Gangajaliya","nishith@icloud.com");
		Student tempStudent2 = new Student("Kashyap","Panchani","kp@icloud.com");
		Student tempStudent3 = new Student("Shrey","Pobaru","shrey@icloud.com");

		System.out.println("Saving student objects...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Noopur","Gangajaliya","noopur@icloud.com");

		System.out.println("Saving student object...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
