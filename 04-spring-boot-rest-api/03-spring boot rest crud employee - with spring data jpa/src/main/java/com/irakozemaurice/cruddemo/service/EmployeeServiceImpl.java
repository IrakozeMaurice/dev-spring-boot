package com.irakozemaurice.cruddemo.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irakozemaurice.cruddemo.dao.EmployeeRepository;
import com.irakozemaurice.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeDao) {
		this.employeeRepository = employeeDao;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Employee save(Employee theEmployee) {
		return employeeRepository.save(theEmployee);
	}

	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		if(result.isPresent()){
			theEmployee = result.get();
		}else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		return theEmployee;
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}
}
