package com.mirror.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEureka10001Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEureka10001Application.class);
	}
	
}
