package com.zh.thank.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.web.client.RestTemplate;

public class HelloCommand extends HystrixCommand<Object> {

    private static final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("");
    private RestTemplate restTemplate;
    private String id;
    public HelloCommand(RestTemplate restTemplate, String id){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("HelloGoup")).andCommandKey(GETTER_KEY));
        this.restTemplate = restTemplate;
        this.id = id;
    }
    @Override
    protected Object run() {
        String body = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        flushCache(id);
        return body;
    }
    @Override
    protected String getFallback() {
        return "error";
    }

    public static void flushCache(String id){
        HystrixRequestCache.getInstance(GETTER_KEY, HystrixConcurrencyStrategyDefault.getInstance()).clear(id);
    }

    @Override
    protected String getCacheKey() {
        return id;
    }
}
