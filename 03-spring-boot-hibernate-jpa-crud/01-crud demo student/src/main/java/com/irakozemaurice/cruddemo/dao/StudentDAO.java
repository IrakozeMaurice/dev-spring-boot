package com.irakozemaurice.cruddemo.dao;

import java.util.List;

import com.irakozemaurice.cruddemo.entity.Student;

public interface StudentDAO {

	void save(Student theStudent);
	
	Student findById(Integer id);
	
	List<Student> findAll();
	
	List<Student> findByLastname(String lastname);
	
	void update(Student theStudent);
	
	void delete(Integer id);
	
	int deleteAll();
	
}
