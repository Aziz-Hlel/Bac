package com.tigana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;

import com.tigana.Utils.AppProperties;
import com.tigana.shared.Dto.SimpleApiResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RestController()
@RequestMapping("")
@EnableConfigurationProperties(AppProperties.class)
public class BacApplication {

	public static void main(String[] args) {
		SpringApplication.run(BacApplication.class, args);
	}

	@GetMapping("/")
	public SimpleApiResponse getMethodName() {
		return new SimpleApiResponse("scwx");
	};

	@GetMapping("/health")
	public SimpleApiResponse healthCheck() {

		return new SimpleApiResponse("I feel good!");
	};

}
