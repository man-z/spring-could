package com.zh.thank.could.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass().getSimpleName());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello",method= RequestMethod.GET)
    public String home() throws IOException {
        System.out.println(Thread.currentThread().getName()+"----->index");
        System.out.print("<-----------------"+this.getClass().getSimpleName());
//        ServiceInstance localServiceInstance = client.getLocalServiceInstance();
//        logger.info("/hello, host:"+localServiceInstance.getHost()+", service_id:"+localServiceInstance.getServiceId());
        return "hello word!";
    }
    @RequestMapping(value = "/hellos",method= RequestMethod.GET)
    public List<String> homes(@RequestParam String ids) throws IOException {
        System.out.println(Thread.currentThread().getName()+"----->index");
        System.out.print("<-----------------"+this.getClass().getSimpleName());
        System.out.print("---------------->"+ids);
//        ServiceInstance localServiceInstance = client.getLocalServiceInstance();
//        logger.info("/hello, host:"+localServiceInstance.getHost()+", service_id:"+localServiceInstance.getServiceId());
        return Arrays.asList(ids.split(","));
    }
}
