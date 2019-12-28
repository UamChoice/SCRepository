package com.base.thread;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步操作，不要求立即返回
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        c4();
    }

    public static void c1() throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture = new CompletableFuture<String>();
        completableFuture.complete("result");

        System.out.println(completableFuture.get());
    }

    //异步执行，阻塞
    public static void c2() throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture = CompletableFuture.runAsync(()-> System.out.println("print "));
        completableFuture.get();
        System.out.println("end...");
    }

    //异步执行，阻塞
    public static void c3() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            return Thread.currentThread().getName()+","+ "Hello";
        });
        System.out.println(completableFuture.get());
        System.out.println("end...");
    }

    //合并操作
    public static void c4() throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            //int a =9/0;
            return Thread.currentThread().getName()+","+ "Hello";
        }).thenApply(value->{
            return value+" 来自数据库";
        }).thenApply(v->{
            return v+ " "+LocalDate.now();
        }).thenApply(v->{
            System.out.println(v);
            return v;
        }).thenRun(()->{
            System.out.println("等待结束");
        }).exceptionally(throwable -> {
            System.out.println(throwable.getMessage());
            return null;
        });

        System.out.println("end...");
    }
}
