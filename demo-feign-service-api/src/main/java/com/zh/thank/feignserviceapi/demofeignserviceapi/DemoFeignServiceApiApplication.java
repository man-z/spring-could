package com.zh.thank.feignserviceapi.demofeignserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.zh.*")
//@EnableFeignClients(basePackages = "com.zh.*")
public class DemoFeignServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoFeignServiceApiApplication.class, args);
	}

}
