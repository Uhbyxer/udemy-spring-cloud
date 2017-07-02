package com.acme.lab4eurekaserversolution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Lab4EurekaServerSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab4EurekaServerSolutionApplication.class, args);
	}
}
