package com.mirror.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirror.feign.client.MyClient;

@RestController
// 重新抓取配置文件后,添加了该注解的文件才有效
@RefreshScope
public class FeignController {

	@Autowired
	private MyClient myClient;
	
	@Value("${com.name}")
	private String name;
	
	@GetMapping("/test2")
	public String hello() {
		String result = myClient.hello();
		return "消费者30080被调用,结果:"+result+"配置文件读取的信息:"+name;
	}
	
}
