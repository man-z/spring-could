package com.zh.thank.zuulapigateway.demozuulapigateway;

import com.netflix.zuul.FilterProcessor;
import com.zh.thank.zuulapigateway.filter.AccessFilter;
import com.zh.thank.zuulapigateway.filter.ThankFilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.zh.*"})
@EnableZuulProxy
public class DemoZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoZuulApiGatewayApplication.class, args);
		//让自定义过滤器生效
		FilterProcessor.setProcessor(new ThankFilterProcessor());
	}

	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}
}
