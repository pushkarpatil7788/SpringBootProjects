package com.example.demo_OrderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoOrderServiceApplication.class, args);
	}

}
