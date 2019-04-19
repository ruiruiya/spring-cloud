package com.mirror.dashbard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class SpringCloudDashbard50000Application {
	
	/**
	 * 	监控仪表盘
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDashbard50000Application.class);
	}
}
