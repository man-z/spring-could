package com.zh.thank.serviceIpm;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    @CacheResult
    @HystrixCommand(defaultFallback = "helloFallback")
    public String helloService(@CacheKey String id){
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }

    @HystrixCollapser(batchMethod = "findAll",scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds",value = "100")})
    public String find(String id){
        System.out.println(Thread.currentThread().getName()+"--------------------->"+id);
        return null;
    }

    @HystrixCommand
    public List<String> findAll(List<String> ids){
        System.out.println(Thread.currentThread().getName()+"---------------------fiandAll:"+ids.toString());
        return restTemplate.getForObject("http://HELLO-SERVICE/hellos?ids={1}",List.class, org.apache.commons.lang.StringUtils.join(ids,","));
    }



    @HystrixCommand(defaultFallback = "helloFallback", commandKey = "helloKey")
    public String heoll(){
        return "111";
    }

    public String helloFallback(){
        return "error";
    }
}
