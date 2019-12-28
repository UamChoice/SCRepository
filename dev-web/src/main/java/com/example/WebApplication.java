package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
		//SpringApplication application = new SpringApplication(WebApplication.class);
        // 第四种读取properties方式：注册监听器
        //application.addListeners(new PropertiesListener("read_pro.properties"));
        //application.run(args);
	}
}
