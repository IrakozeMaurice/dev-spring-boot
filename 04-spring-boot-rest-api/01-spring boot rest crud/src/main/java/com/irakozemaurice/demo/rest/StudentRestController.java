package com.irakozemaurice.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irakozemaurice.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	// define @PostConstruct to load data ... only once instead of loading data for
	// every request
	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		students.add(new Student("John", "Doe"));
		students.add(new Student("Mary", "Public"));
		students.add(new Student("Jane", "Doe"));
	}

	// define endpoint "/students" - returns a list of students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	// define endpoint "/students/{studentId}" - returns a student by student id
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		// check the student id against the list size
		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		return students.get(studentId);
	}
}
