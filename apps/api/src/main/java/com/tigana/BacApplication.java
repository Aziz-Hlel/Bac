package com.tigana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.tigana.Utils.ApiResponse;
import com.tigana.Utils.AppProperties;

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
	public String getMethodName() {
		return "scwx";
	};

	@GetMapping("/health")
	public ResponseEntity<ApiResponse<String>> healthCheck() {

		ApiResponse<String> response = new ApiResponse<>();
		response.setMessage("API is healthy");
		return ResponseEntity.status(HttpStatus.OK)
				.body(ApiResponse.<String>builder()
						.message(null)
						.status(HttpStatus.OK)
						.build());
	};

}
