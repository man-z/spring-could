package com.zh.thank.could.democould;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ConcurrentHashMap;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoCouldApplicationTests {

	@Test
	public void contextLoads() {
		ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(3);
		Object o = concurrentHashMap.putIfAbsent("123", 123);
		Object o1 = concurrentHashMap.putIfAbsent("123", 123);
		System.out.println(o);
		System.out.println(o1);
	}


}
