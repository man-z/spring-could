package com.zh.thank.configclient.democonfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication(scanBasePackages = {"com.zh.*"})
@EnableDiscoveryClient
public class DemoConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoConfigClientApplication.class, args);
	}

//	@Bean
//	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
//		PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
//		c.setIgnoreUnresolvablePlaceholders(true);
//		return c;
//	}

}

