package com.irakozemaurice.springcoredemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	// define a private field for the dependency
	private Coach coach;


	// define a constructor for dependency injection
	public DemoController(@Qualifier("cricketCoach") Coach coach) {
		System.out.println("In constructor: " + getClass().getSimpleName());
		this.coach = coach;
	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return coach.getDailyWorkout();
	}
}
