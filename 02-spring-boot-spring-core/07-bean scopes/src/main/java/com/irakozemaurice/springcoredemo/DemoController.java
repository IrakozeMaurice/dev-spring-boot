package com.irakozemaurice.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private Coach coach;
	private Coach anotherCoach;

	// define a constructor for dependency injection
	@Autowired
	public DemoController(@Qualifier("cricketCoach") Coach coach,@Qualifier("cricketCoach") Coach anotherCoach) {
		this.coach = coach;
		this.anotherCoach = anotherCoach;
	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return coach.getDailyWorkout();
	}
	
	@GetMapping("/check")
	public String checkCoach() {
		return "Bean scope comparison: Coach = Another Coach " + (coach == anotherCoach);
	}
}
