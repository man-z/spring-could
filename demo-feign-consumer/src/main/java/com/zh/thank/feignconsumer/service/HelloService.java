package com.zh.thank.feignconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("hello-service1")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();
}
