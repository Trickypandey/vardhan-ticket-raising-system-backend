package com.VardhanProject.Springboot_backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SpringbootBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootBackendApplication.class, args);
		System.out.println("Test checking biatch");
		System.out.println("nfjkabsdkfb");

	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
