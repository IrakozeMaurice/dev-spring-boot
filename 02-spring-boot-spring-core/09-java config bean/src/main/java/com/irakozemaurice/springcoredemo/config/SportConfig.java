package com.irakozemaurice.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.irakozemaurice.springcoredemo.Coach;
import com.irakozemaurice.springcoredemo.SwimCoach;

@Configuration
public class SportConfig {

	@Bean("aquatic")
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
