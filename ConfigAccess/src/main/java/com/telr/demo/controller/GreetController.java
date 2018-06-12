package com.telr.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class GreetController {

	@Value("${user.name}")
	private String personName;
	
	@RequestMapping("/greeting")
	public String greet(){
		return "Hello " + personName;
 	}
	
}
