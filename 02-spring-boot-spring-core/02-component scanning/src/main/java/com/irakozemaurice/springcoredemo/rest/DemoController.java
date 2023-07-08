package com.irakozemaurice.springcoredemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irakozemaurice.util.Coach;

@RestController
public class DemoController {

	// define a private field for the dependency
	private Coach coach;
	
	
	// define a constructor for dependency injection
	public DemoController(Coach coach) {
		this.coach = coach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return coach.getDailyWorkout();
	}
}
