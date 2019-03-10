package com.zh.thank.feignconsumer.service;

import com.zh.thank.feignconsumer.service.backIpm.HelloServiceFallback;
import com.zh.thank.feignserviceapi.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * feign继承特性，
 */
@FeignClient(name = "HELLO-SERVICE",fallback = HelloServiceFallback.class)
//@RequestMapping("/fallback/refactor")
public interface RefactorHelloService extends HelloService {
}
