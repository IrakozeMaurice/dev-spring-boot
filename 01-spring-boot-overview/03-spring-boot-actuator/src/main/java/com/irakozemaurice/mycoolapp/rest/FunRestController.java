package com.irakozemaurice.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@Value("${author.name}")
	String name;
	@GetMapping("/")
	public String sayHello() {
		return "Hi " + name;
	}
}
