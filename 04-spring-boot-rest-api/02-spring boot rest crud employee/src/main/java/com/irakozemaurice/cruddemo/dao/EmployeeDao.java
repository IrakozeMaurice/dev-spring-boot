package com.irakozemaurice.cruddemo.dao;

import java.util.List;

import com.irakozemaurice.cruddemo.entity.Employee;

public interface EmployeeDao {

	List<Employee> findAll();
	
	Employee save(Employee theEmployee);
	
	Employee findById(int theId);
	
	void deleteById(int theId);
}
