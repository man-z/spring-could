package com.zh.thank.eurekaclient.demoeurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zh.*"})
@EnableDiscoveryClient
public class DemoEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaClientApplication.class, args);
	}

}
