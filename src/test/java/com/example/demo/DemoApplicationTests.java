package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	//定义Logger
	private static final Logger DemoTestLogger = LoggerFactory.getLogger(DemoApplicationTests.class);
	@Test
	public void contextLoads() {
		testErrLog();
	}
	
	private static void testErrLog() {
		try {
			int a = 5/0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DemoTestLogger.error(e.toString());
			e.printStackTrace();
		}
	}
}
