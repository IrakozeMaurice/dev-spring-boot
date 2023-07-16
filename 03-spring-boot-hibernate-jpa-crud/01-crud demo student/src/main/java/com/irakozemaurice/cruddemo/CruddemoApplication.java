package com.irakozemaurice.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.irakozemaurice.cruddemo.dao.StudentDAO;
import com.irakozemaurice.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			
			// create a student
//			createStudent(studentDAO);
			
			// read a student
//			readStudent(studentDAO);
			
			// read all students
//			findAllStudents(studentDAO);
			
			// read students by last name
//			readByLastname(studentDAO);
			
			// update a student
//			updateStudent(studentDAO);
			
			// delete a student
//			deleteStudent(studentDAO);
			
			// delete all students
//			deleteAllStudents(studentDAO);
			
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("deleting all students ...");
		int rows = studentDAO.deleteAll();
		System.out.println("number of students deleted : " + rows);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		System.out.print("list of students before\n-----------------------------\n");
		findAllStudents(studentDAO);
		
		System.out.println("deleting student with id 3 ....");
		studentDAO.delete(3);
		System.out.print("list of students after\n-----------------------------\n");
		findAllStudents(studentDAO);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student myStudent = studentDAO.findById(studentId);
		System.out.println("retrieved student: " + myStudent);
		System.out.println("updating student ...");
		myStudent.setFirstname("scooby");
		studentDAO.update(myStudent);
		System.out.println("updated student: " + myStudent);
	}

	private void readByLastname(StudentDAO studentDAO) {
		System.out.println("retrieving students by lastname");
		List<Student> students = studentDAO.findByLastname("doe");
		for(Student s : students) {
			System.out.println(s);
		}
	}

	private void findAllStudents(StudentDAO studentDAO) {
		System.out.println("retrieving all students ...");
		List<Student> students = studentDAO.findAll();
		for(Student s : students) {
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("creating the student object ...");
		Student tempStudent = new Student("Jane","Doe","janedoe@example.com");
		System.out.println("saving the student");
		studentDAO.save(tempStudent);
		System.out.println("saved student. Generated id: " + tempStudent.getId());
		
		System.out.println("retrieving the student....");
		tempStudent = studentDAO.findById(tempStudent.getId());
		System.out.println("Found the student: " + tempStudent);
		
	}

	private void createStudent(StudentDAO studentDAO) {
		
		System.out.println("creating the student object ...");
		Student tempStudent = new Student("Jane","Doe","janedoe@example.com");
		
		System.out.println("saving the student");
		studentDAO.save(tempStudent);
		
		System.out.println("saved student. Generated id: " + tempStudent.getId());
	}
}
