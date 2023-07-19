package com.irakozemaurice.cruddemo.service;

import java.util.List;

import com.irakozemaurice.cruddemo.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee save(Employee theEmployee);

	Employee findById(int theId);

	void deleteById(int theId);
}
