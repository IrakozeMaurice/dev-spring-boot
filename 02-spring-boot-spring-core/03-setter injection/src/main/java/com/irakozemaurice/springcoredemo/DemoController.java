package com.irakozemaurice.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	// define a private field for the dependency
	private Coach coach;
	
	
	// define a setter method for dependency injection ( can have any name )
	@Autowired
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return coach.getDailyWorkout();
	}
}
