package com.base.thread;

import com.base.test.Test;

import java.util.concurrent.*;

public class FutureUse {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(()-> new Test().getStr());
        executorService.shutdown();
        try {
            Thread.sleep(1000);
            System.out.println("1s gone");
            String o = future.get();
            Thread.sleep(2000);
            System.out.println("2s gone");
            System.out.println("Future: "+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Main go on");
    }
}
