package com.zh.thank.serviceIpm;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @CacheResult
    @HystrixCommand(defaultFallback = "helloFallback")
    public String helloService(@CacheKey String id){
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }


    @HystrixCommand(defaultFallback = "helloFallback", commandKey = "helloKey")
    public String heoll(){
        return "111";
    }

    public String helloFallback(){
        return "error";
    }
}
