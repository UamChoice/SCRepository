package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.tools.PropertiesListener;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		SpringApplication application = new SpringApplication(DemoApplication.class);
        // 第四种读取properties方式：注册监听器
        //application.addListeners(new PropertiesListener("read_pro.properties"));
        application.run(args);
	}
}
