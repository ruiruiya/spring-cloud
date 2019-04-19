package com.mirror.gatewey.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class MyGatewayFilter implements GatewayFilter, Ordered {

	// GatewayFilter 局部过滤器   实现GloabFilter为全局过滤器
	
	/**
	 * 	当前过滤器的顺序,值越小,优先级越高
	 */
	@Override
	public int getOrder() {
		return 1;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("拦截到请求:"+exchange.getRequest().getURI().getPath());
		return chain.filter(exchange);//这里做测试使用,直接放行
	}

}
