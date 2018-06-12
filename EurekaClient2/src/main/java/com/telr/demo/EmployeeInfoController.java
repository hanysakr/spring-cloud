package com.telr.demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class EmployeeInfoController {

	@Autowired
	private EmployeeServiceProxy employeeServiceProxy;

	@RequestMapping("/dashboard/feign/{id}")
	public Employee findme(@PathVariable Long id) {
		return employeeServiceProxy.findById(id);
	}

	@RequestMapping("/dashboard/feign/peers")
	public Collection<Employee> findPeers() {
		return employeeServiceProxy.findAll();
	}
}
