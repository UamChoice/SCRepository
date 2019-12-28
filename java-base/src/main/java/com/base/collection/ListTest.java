package com.base.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTest {
    public static void main(String[] args) {
        streamTest();
    }

    public static void streamTest(){
        //one construct
        List list = Arrays.asList("sa","super");
        list.forEach(System.out::println);

        //tow cons
        Stream<String>  stream = Stream.of("a","f","v","c");
        List list1 =  stream.collect(Collectors.toList());
        list1.forEach(System.out::println);
    }
}
