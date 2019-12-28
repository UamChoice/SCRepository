package com.base.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        String s = "Hello World";
        String[] ss = s.split("");
        Stream.of(ss).forEach(System.out::println);

        List<String[]> list = Stream.of(s).map(str-> str.split("")).collect(Collectors.toList());
        List<Stream<String>> collect = Stream.of(s).map(str -> str.split("")).map(p -> Arrays.stream(p)).collect(Collectors.toList());
    }

    public String getStr(){
        try {
            System.out.println("get msg from Test START");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("get msg from Test END");
        return "Test msg";
    }
}
