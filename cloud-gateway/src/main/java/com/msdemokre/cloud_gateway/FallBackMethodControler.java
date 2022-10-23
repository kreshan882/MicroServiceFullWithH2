package com.msdemokre.cloud_gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodControler {

	@GetMapping("/userServiceFallBack")
	public String userServiceFallBackMethod() {
		return "the user service is down";
	}
	
	@GetMapping("/departmentServiceFallBack")
	public String departmentServiceFallBackMethod() {
		return "the department service is down";
	}
}
