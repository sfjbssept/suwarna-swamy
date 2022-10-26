package com.aws.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringAwsDeployApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAwsDeployApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String helloWorld() {
		
		return "hello world !";
	}

}
