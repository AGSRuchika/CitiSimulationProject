package com.example.ProfileBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ProfileBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileBuilderApplication.class, args);
	}

}
