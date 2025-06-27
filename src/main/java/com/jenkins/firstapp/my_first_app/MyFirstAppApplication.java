package com.jenkins.firstapp.my_first_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyFirstAppApplication {

	@GetMapping("/")
	public ResponseEntity<String> helloWorld() {
		return ResponseEntity.status(200).body("Hello");
	}


	public static void main(String[] args) {
		SpringApplication.run(MyFirstAppApplication.class, args);
	}

}
