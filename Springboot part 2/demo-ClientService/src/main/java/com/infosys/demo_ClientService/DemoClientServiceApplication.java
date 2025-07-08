package com.infosys.demo_ClientService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoClientServiceApplication.class, args);
	}

}
