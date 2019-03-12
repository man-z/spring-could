package com.zh.thank.apigatewaydynamicroute.demoapigatewaydynamicroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class DemoApiGatewayDynamicRouteApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApiGatewayDynamicRouteApplication.class, args);
	}

	@Bean
	@RefreshScope
	@ConfigurationProperties("zuul")
	public ZuulProperties zuulProperties(){
		return new ZuulProperties();
	}
}
