package com.mirror.proveder.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvederController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping("/hello")
	public String hello() {
		return "提供者被调用,端口:"+port;
	}
}
