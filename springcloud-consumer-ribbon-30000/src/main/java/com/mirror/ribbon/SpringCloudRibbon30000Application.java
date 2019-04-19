package com.mirror.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableHystrix
public class SpringCloudRibbon30000Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRibbon30000Application.class);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	//替换负载均衡策略(默认轮询算法?)
	@Bean
	public IRule getIRule() { 
		return new RandomRule();//随机算法
	}
}
