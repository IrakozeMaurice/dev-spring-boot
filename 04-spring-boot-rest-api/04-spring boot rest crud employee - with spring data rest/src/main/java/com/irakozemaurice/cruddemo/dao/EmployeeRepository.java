package com.irakozemaurice.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irakozemaurice.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	// will inherit all crud methods for dao
}
