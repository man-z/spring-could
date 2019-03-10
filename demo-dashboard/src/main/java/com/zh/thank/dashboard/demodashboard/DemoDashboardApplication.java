package com.zh.thank.dashboard.demodashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DemoDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDashboardApplication.class, args);
	}

}
