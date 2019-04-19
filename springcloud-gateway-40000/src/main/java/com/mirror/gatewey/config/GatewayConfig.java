package com.mirror.gatewey.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;

import com.mirror.gatewey.filter.MyGloabFilter;

import reactor.core.publisher.Mono;

@Configuration
public class GatewayConfig {
	
	
	/**
	 * 	配置限流的规则bean
	 * 	通过ip限流
	 */
	@Bean(name="remoteAddrKeyResolver")
	public KeyResolver getKeyResolver() {
		return new KeyResolver() {
			@Override
			public Mono<String> resolve(ServerWebExchange exchange) {
				return Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
			}
		};
	}

	// 配置全局过滤器
	//@Bean
	public GlobalFilter getGlobalFilter() {
		return new MyGloabFilter();
	}
	
	// 通过Java代码的方式配置路由规则
	//@Bean
	public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(new Function<PredicateSpec, Route.Builder>() {

					@Override
					public Route.Builder apply(PredicateSpec predicateSpec) {
						return predicateSpec
								.path("/a/**")
								.filters(new Function<GatewayFilterSpec, UriSpec>() {
									@Override
									public UriSpec apply(GatewayFilterSpec gatewayFilterSpec) {
										return gatewayFilterSpec.stripPrefix(1);//.filter(gatewayFilter)(局部过滤器)在这里配置过滤器 ,自定义过滤器传入这里
									}
								})
								.uri("lb://COMSUMER-FEIGN")
								.id("consumer-feign");
					}
				})
				.route(new Function<PredicateSpec, Route.Builder>() {

					@Override
					public Route.Builder apply(PredicateSpec predicateSpec) {
						return predicateSpec
								.path("/b/**")
								.filters(new Function<GatewayFilterSpec, UriSpec>() {
									@Override
									public UriSpec apply(GatewayFilterSpec gatewayFilterSpec) {
										return gatewayFilterSpec.stripPrefix(1);
									}
								})
								.uri("lb://COMSUMER-RIBBON")
								.id("consumer-ribbon");
					}
				}).build();
	}
	
}
