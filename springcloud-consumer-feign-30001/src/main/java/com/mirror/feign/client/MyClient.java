package com.mirror.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="proveder",fallback = MyClientImpl.class)
public interface MyClient {

	@GetMapping("/hello")
	public String hello();
	
}
