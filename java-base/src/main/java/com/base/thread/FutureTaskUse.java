package com.base.thread;

import com.base.test.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskUse {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask(()->new Test().getStr());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(futureTask);
        executorService.shutdown();

        String s = null;
        try {
            s = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(s);

    }
}
