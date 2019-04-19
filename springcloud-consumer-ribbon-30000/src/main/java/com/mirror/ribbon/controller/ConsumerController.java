package com.mirror.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate reetTemplate;
	
	@HystrixCommand(fallbackMethod = "fallBack")
	@GetMapping("/test")
	public String hello() {
		
		//URL写提供的注册中心的名字,相同名字的提供者会被eureka认为是集群
		String result = reetTemplate.getForObject("http://PROVEDER/hello", String.class);
		return "消费者30000被调用,结果:"+result;
	}
	
	public String fallBack() {
		return "进入降级方法,服务繁忙,请稍后再试";
	}
	
}
