package com.zh.thank.controller;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.zh.thank.command.HelloCommand;
import com.zh.thank.serviceIpm.HelloService;
import com.zh.thank.serviceIpm.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @Autowired
    UserService userService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer(@RequestParam String id) throws InterruptedException {
        //Hystrix的缓存实现，这功能有点鸡肋。
//        CountDownLatch cd = new CountDownLatch(2);
//        CountDownLatch cd1 = new CountDownLatch(1);
        final StringBuilder execute = new StringBuilder();
        HystrixRequestContext.initializeContext();
//        new Thread(()->{
//            try {
//                cd.countDown();
//                cd1.await();
//                System.out.println(Thread.currentThread().getName()+"<----------------------");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            for (int i = 0; i < 5; i++) {
//                HelloCommand command = new HelloCommand(restTemplate, id);
//                execute.append(command.execute().toString());//清理缓存
//                System.out.println(execute);
//            }
//        }).start();
//        new Thread(()->{
//            try {
//                cd.countDown();
//                cd1.await();
//                System.out.println(Thread.currentThread().getName()+"-------------------->");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            for (int i = 0; i < 5; i++) {
//                HelloCommand command = new HelloCommand(restTemplate, id);
//                execute.append(command.execute().toString());//清理缓存
//                System.out.println(execute);
//            }
//        }).start();
//        cd.await();
//        cd1.countDown();
//       HystrixRequestCache.getInstance("hello").clear();
        for (int i = 0; i < 5; i++) {
//            HelloCommand command = new HelloCommand(restTemplate, id);
            execute.append(helloService.helloService(id));//清理缓存
//            execute.append(command.execute().toString());//清理缓存
            System.out.println(execute);
        }
        return execute.toString();
//        return helloService.helloService(id);
    }

    @RequestMapping(value = "/hellos",method = RequestMethod.GET)
    public String hellos() throws InterruptedException {
        CountDownLatch cd = new CountDownLatch(2);
        CountDownLatch cd1 = new CountDownLatch(1);
        List<String> ids = new ArrayList<>(30);
        HystrixRequestContext.initializeContext();
        for (int i = 0; i < 40; i++) {
            ids.add(i+"");
        }
        StringBuilder hello = new StringBuilder();
//        new Thread(()->{
//            try {
//                cd.countDown();
//                cd1.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            for (int i = 0; i < 30; i++) {
                hello.append(userService.find(i+""));
            }
//        }).start();

//        cd.await();
//        cd1.countDown();
        return hello.toString();
    }
}
