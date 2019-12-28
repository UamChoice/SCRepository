package com.base.thread;

public class ThreadTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket,"窗口1");
        Thread thread2 = new Thread(ticket,"窗口2");
        Thread thread3 = new Thread(ticket,"窗口3");
        Thread thread4 = new Thread(ticket,"窗口4");
        Thread thread5 = new Thread(ticket,"窗口5");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}


class Ticket implements Runnable{
    private static int total = 1000;
    @Override
    public void run() {
        while (true){
            synchronized (Ticket.class){
                if (total <= 0) {
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" total: "+ total);
                total --;
            }
        }
    }
}