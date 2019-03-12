package com.zh.thank.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Value("${from}")
    private String from;

//    @Autowired
//    private Environment env;

    @RequestMapping("/from")
    public String from(){
//        return env.getProperty("from");
//        return env.getProperty("from", "undefined");
        return this.from;

    }
}
