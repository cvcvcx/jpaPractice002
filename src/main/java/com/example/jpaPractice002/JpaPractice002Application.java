package com.example.jpaPractice002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaPractice002Application {

	public static void main(String[] args) {
		SpringApplication.run(JpaPractice002Application.class, args);
	}

}
