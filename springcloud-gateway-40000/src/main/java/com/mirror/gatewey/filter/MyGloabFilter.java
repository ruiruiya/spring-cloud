package com.mirror.gatewey.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

//全局过滤器
public class MyGloabFilter implements GlobalFilter,Ordered {

	@Override
	public int getOrder() {
		return 100;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("拦截到请求:"+exchange.getRequest().getURI().getPath());
		return chain.filter(exchange);//这里做测试使用,直接放行
	}

}
