package com.example.other;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SyncTest {
    /**
     * 异步，会起一个新的线程   name is Task
     */
    @Async
    public void test(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" 正在执行: " +i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
