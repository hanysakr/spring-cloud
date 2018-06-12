package com.telr.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigAccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigAccessApplication.class, args);
		//  curl -X POST localhost:8080/actuator/refresh -d {} -H "Content-Type: application/json" for refresh
	}
	
	 
}
