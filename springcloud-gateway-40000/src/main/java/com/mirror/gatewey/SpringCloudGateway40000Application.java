package com.mirror.gatewey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudGateway40000Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGateway40000Application.class);
	}
}
