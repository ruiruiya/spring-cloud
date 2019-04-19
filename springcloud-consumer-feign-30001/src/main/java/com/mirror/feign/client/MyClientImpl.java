package com.mirror.feign.client;

import org.springframework.stereotype.Component;

@Component
public class MyClientImpl implements MyClient {

	@Override
	public String hello() {
		return "feign调用进入降级方法,系统繁忙,请稍后再试";
	}

}
