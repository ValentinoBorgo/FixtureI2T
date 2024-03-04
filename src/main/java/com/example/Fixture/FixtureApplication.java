package com.example.Fixture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FixtureApplication {

	public static void main(String[] args) {
		System.out.println("En funcionamiento");
		SpringApplication.run(FixtureApplication.class, args);
	}

}
