package com.base.eight.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapDemo {
    public static void main(String[] args) {
        String s = "Hello World";
        String[] ss = s.split("");
        Stream.of(ss).forEachOrdered(System.out::println);

        List<String[]> list = Stream.of(s).map(str-> str.split("")).collect(Collectors.toList());
        Stream.of(list).forEach(System.out::println);

        //使用map
        List<Stream<String>>  collect= Stream.of(s).map(str -> str.split("")).map(p -> Arrays.stream(p)).collect(Collectors.toList());
        Stream.of(collect).forEach(System.out::println);

        //使用flatMap
        List<String> strings = Stream.of(s).map(str -> str.split("")).flatMap(p -> Arrays.stream(p)).collect(Collectors.toList());

    }
}
