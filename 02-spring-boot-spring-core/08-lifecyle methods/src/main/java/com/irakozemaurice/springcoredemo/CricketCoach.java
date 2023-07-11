package com.irakozemaurice.springcoredemo;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CricketCoach implements Coach{

	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("connect to the database ...");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("close the database ...");
	}
}
