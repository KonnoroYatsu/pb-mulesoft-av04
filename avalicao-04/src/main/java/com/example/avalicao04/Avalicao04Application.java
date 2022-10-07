package com.example.avalicao04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Avalicao04Application {

	public static void main(String[] args) {
		SpringApplication.run(Avalicao04Application.class, args);
	}

}
