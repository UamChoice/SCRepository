package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import com.example.tools.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.tools.PropertiesReadTool;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	private static final Logger DemoTestLogger = LoggerFactory.getLogger(DemoApplicationTests.class);
	@Autowired
	RedisUtil redisUtil;

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

	@Test
	public void testRedis(){
		System.out.println(redisUtil.get("key1"));
	}
}
