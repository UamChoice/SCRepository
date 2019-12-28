package com.base.eight.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Ram","Shyam","Shiv","Mahesh");
        String result=  list.stream().collect(Collectors.joining());
        //RamShyamShivMahesh
        System.out.println(result);
        //Ram,Shyam,Shiv,Mahesh
        result=  list.stream().collect(Collectors.joining(","));
        System.out.println(result);

        //中间以及前后增加修饰并输出
        //[Ram-Shyam-Shiv-Mahesh]
        result=  list.stream().collect(Collectors.joining("-","[","]"));
        System.out.println(result);
    }
}
