package com.zh.thank.feignconsumer.service.backIpm;

import com.zh.thank.feignconsumer.service.RefactorHelloService;
import com.zh.thank.feignserviceapi.model.User;
import com.zh.thank.feignserviceapi.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceFallback implements RefactorHelloService{
    @Override
    public String hello11(String name) {
        return "error";
    }

    @Override
    public User hello11(String name, Integer age) {
        return new User("未知",0);
    }

    @Override
    public String hello11(User user) {
        return "error";
    }
}
