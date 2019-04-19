package com.mirror.proveder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudProveder20001Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProveder20001Application.class);
	}
}
