package com.zh.thank.feignserviceapi.service;

import com.zh.thank.feignserviceapi.model.User;
import org.springframework.web.bind.annotation.*;

//@FeignClient(name = "HELLO-SERVICE",fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping(value = "/hello4",method = RequestMethod.GET)
    String hello11(@RequestParam("name") String name);

    @RequestMapping(value = "/hello5", method = RequestMethod.GET)
    User hello11(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello6", method = RequestMethod.POST)
    String hello11(@RequestBody User user);
}
