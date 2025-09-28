package com.tigana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@RestController()
@RequestMapping("/api/")
public class BacApplication {

	public static void main(String[] args) {
		SpringApplication.run(BacApplication.class, args);
	}

	@GetMapping
	public String getMethodName() {
		return "scwx";
	};
	

}
