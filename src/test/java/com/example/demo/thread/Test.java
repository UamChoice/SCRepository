package com.example.demo.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logger.info("当前时间{}",format);

        List<String> list = Arrays.asList("piter","alice","lilei","hanmeimei");
        list.stream().map(s -> s + "_end").filter(s -> s.length() > 10).forEach(s -> System.out.println(s));
    }
}
