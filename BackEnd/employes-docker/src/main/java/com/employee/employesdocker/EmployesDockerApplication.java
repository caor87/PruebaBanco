package com.employee.employesdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EmployesDockerApplication {

	@RequestMapping("/")
	public String home() {
		return "Docker SigIn";
	}
	public static void main(String[] args) {
		SpringApplication.run(EmployesDockerApplication.class, args);
	}

}
