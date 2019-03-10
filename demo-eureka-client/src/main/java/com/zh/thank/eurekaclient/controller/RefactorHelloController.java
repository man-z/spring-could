package com.zh.thank.eurekaclient.controller;


import com.zh.thank.feignserviceapi.model.User;
import com.zh.thank.feignserviceapi.service.HelloService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloController  implements HelloService{

    @Override
    public String hello11( String name) {
        return "Hello "+name;
    }

    @Override
    public User hello11( String name,  Integer age) {
        return new User(name,age);
    }

    @Override
    public String hello11( User user) {
        return "Hello "+user.getName()+", "+user.getAge();
    }
}
