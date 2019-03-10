package com.zh.thank.feignconsumer.demofeignconsumer;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.zh.*")
//使用eureka客户端，discovery扩展了eureka
@EnableDiscoveryClient
//使用feign，feign整合了ribbon和hystrix
@EnableFeignClients(basePackages = {"com.zh.*","com.zh.thank.feignserviceapi.service"})
public class DemoFeignConsumerApplication {

	//开启feign日志级别
	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoFeignConsumerApplication.class, args);
	}

}
