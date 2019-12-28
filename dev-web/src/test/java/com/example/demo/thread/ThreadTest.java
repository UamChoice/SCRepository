package com.example.demo.thread;

import com.example.WebApplication;
import com.example.other.SyncTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= WebApplication.class)
public class ThreadTest {
    @Autowired
    private SyncTest syncTest;

    /**
     * main 线程Pre：0...
     * main 线程Last：0...
     * task-1 正在执行: 0...
     *
     * 无注解会顺序执行
     */
    @Test
    public void mainTest() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+ " 线程Pre："+i);
        }
        syncTest.test();
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+ " 线程Last："+i);

        }
    }
}
