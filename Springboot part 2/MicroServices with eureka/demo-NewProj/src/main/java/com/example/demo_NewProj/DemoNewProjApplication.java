package com.example.demo_NewProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoNewProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoNewProjApplication.class, args);
	}

}

