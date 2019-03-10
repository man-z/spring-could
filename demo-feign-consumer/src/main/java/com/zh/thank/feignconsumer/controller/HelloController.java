package com.zh.thank.feignconsumer.controller;

import com.zh.thank.feignconsumer.service.HelloService;
import com.zh.thank.feignconsumer.service.RefactorHelloService;
import com.zh.thank.feignserviceapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @Autowired
//    HelloService helloService;

    @Autowired
    com.zh.thank.feignconsumer.service.RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        return "";
//        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET)
    public String helloConsumer1(){
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello11("MIMI")).append("\n")
                .append(refactorHelloService.hello11("MIMI",20)).append("\n")
                .append(refactorHelloService.hello11(new User("MIMI",100)));
        return sb.toString();
    }
}
