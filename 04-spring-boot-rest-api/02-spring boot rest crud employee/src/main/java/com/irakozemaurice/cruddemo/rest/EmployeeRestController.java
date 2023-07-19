package com.irakozemaurice.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irakozemaurice.cruddemo.entity.Employee;
import com.irakozemaurice.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeDao) {
		this.employeeService = employeeDao;
	}

	// add mapping for GET /employees - get all employees
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeService.findAll();
		return employees;
	}

	// add mapping for POST /employees - add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {

		// if they pass id, set it to zero to force save operation instead of update
		theEmployee.setId(0);

		// save the employee
		Employee dbEmployee = employeeService.save(theEmployee);

		// dbEmployee has a new id from the database
		return dbEmployee;
	}
	
	// add mapping for PUT /employees - update an employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {

		// update the employee
		Employee dbEmployee = employeeService.save(theEmployee);

		// dbEmployee has a new id from the database
		return dbEmployee;
	}

	// add mapping for GET /employees/{employeeId} - get employee by id
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if (theEmployee == null)
			throw new RuntimeException("employee id not found - " + employeeId);
		
		return theEmployee;
	}

	// add mapping for DELETE /employees/{employeeId} - delete an employee
		@DeleteMapping("/employees/{employeeId}")
		public String deleteEmployee(@PathVariable int employeeId) {
		
			Employee theEmployee = employeeService.findById(employeeId);
			
			if (theEmployee == null)
				throw new RuntimeException("employee id not found - " + employeeId);
			
			// delete the employee
			employeeService.deleteById(employeeId);
			
			return "deleted employee - " + employeeId;
		}
		
}
