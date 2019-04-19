package com.mirror.gatewey.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FallBackController {

	//gateway整和hytrix降级方法
	@RequestMapping("/fallback")
	public String fallback() {
		return "系统繁忙,请稍后再试!";
	}
	
}
