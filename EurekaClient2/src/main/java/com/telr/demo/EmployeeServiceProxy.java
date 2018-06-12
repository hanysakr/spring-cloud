package com.telr.demo;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="EmployeeSearchService", url="http://localhost:8080")
public interface EmployeeServiceProxy {

	@RequestMapping("/employee/find/{id}")
	public Employee findById(@PathVariable(value="id") Long id);

	@RequestMapping("/employee/findall")
	public Collection<Employee> findAll();

}
