package com.telr.demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RefreshScope
@RestController
public class EmployeeInfoController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EurekaClient eurekaClient;

	//@Value("EmployeeSearchService")
	private String employeeSearchServiceId = "EmployeeSearchService";

	@RequestMapping("/dashboard/{myself}")
	public String findme(@PathVariable Long myself) {
		Application application = eurekaClient.getApplication(employeeSearchServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		//String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "employee/find/" + myself;
		String url = "http://localhost" + ":" + instanceInfo.getPort() + "/" + "employee/find/" + myself;

		System.out.println("URL" + url);
		String emp = restTemplate.getForObject(url, String.class);
		System.out.println("RESPONSE " + emp);
		return emp;
	}

	@RequestMapping("/dashboard/peers")
	public Collection<EmployeeInfo> findPeers() {
		Application application = eurekaClient.getApplication(employeeSearchServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		//String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "employee/findall";
		String url = "http://localhost" + ":" + instanceInfo.getPort() + "/" + "employee/findall";
		System.out.println("URL" + url);
		Collection<EmployeeInfo> list = restTemplate.getForObject(url, Collection.class);
		System.out.println("RESPONSE " + list);
		return list;
	}
}
