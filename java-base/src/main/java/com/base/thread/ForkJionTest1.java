package com.base.thread;

import java.util.concurrent.*;

public class ForkJionTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkJoinTask<Integer> forkJoinTask = new MyTask(1,100);
        forkJoinPool.submit(forkJoinTask);
        System.out.println(forkJoinTask.get());
        forkJoinPool.shutdown();
        //RunnableFuture
    }
}

class MyTask extends RecursiveTask<Integer>{
    private static final int NUM = 10;
    private int start;
    private int end;

    public MyTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int res = 0;
        if (end -start < NUM){
            for (int i = start; i <= end; i++) {
                res += i;
            }
            System.out.println(Thread.currentThread().getName()+" res is " +res);
            return res;
        }else{
            int middle = (start+end)/2;
            MyTask myTask1 = new MyTask(start,middle);
            MyTask myTask2 = new MyTask(middle,end);
            //myTask1.fork();myTask2.fork();
            invokeAll(myTask1,myTask2);
            res = myTask1.join() + myTask2.join();
            System.out.println(Thread.currentThread().getName()+" res is " +res);

            return res;
        }
    }
}