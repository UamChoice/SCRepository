package com.base.thread;

public class CreateThread {
    public static void main(String[] args) {
        System.out.println("mian start thread");
        type1();
        type2();

        new Thread(() -> System.out.println(Thread.currentThread().getName()+"以函数式编程方式正在执行")).start();
        new Thread(System.out::println).start();
    }

    private static void type1(){
        Thread thread = new MyThread();
        thread.start();
    }

    private static void type2(){
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName()+"以Thread方式正在执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"以Runnable方式正在执行");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
