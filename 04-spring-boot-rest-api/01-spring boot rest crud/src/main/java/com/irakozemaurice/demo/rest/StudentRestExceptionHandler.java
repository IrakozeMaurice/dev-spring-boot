package com.irakozemaurice.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// this method is an exception handler for student not found
	@ExceptionHandler
	// return - Type of the response body (StudentErrorResponse)
	// param - Exception to handle (catches StudentNotfoundException)
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {

		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		// return ResponseEntity
		// params - body, status code
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// add another exception handler ... to catch any other exception
	@ExceptionHandler
	// return - Type of the response body (StudentErrorResponse)
	// param - Exception to handle (catches generic Exception)
	public ResponseEntity<StudentErrorResponse> handleException(Exception e) {

		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		// return ResponseEntity
		// params - body, status code
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
