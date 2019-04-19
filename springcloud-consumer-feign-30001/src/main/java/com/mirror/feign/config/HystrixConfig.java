package com.mirror.feign.config;

import javax.servlet.Servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@Configuration
public class HystrixConfig {

	@Bean
	public ServletRegistrationBean<Servlet> getServletRegistrationBean() {
		ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>();
		
		servletRegistrationBean.setServlet(new HystrixMetricsStreamServlet());
		servletRegistrationBean.addUrlMappings("/hystrix.stream");
		return servletRegistrationBean;
	}
}
