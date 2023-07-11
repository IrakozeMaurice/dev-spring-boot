package com.irakozemaurice.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private Coach coach;

	// define a constructor for dependency injection
	@Autowired
	public DemoController(@Qualifier("aquatic") Coach coach) {
		this.coach = coach;
	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return coach.getDailyWorkout();
	}	
}
