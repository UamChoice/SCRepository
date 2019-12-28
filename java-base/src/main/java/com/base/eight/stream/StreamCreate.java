package com.base.eight.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamCreate {
    /**
     * Stream的构造方法
     */
    public static void createStream(){
        //one
        Stream stream1 = Stream.empty();
        stream1.forEach(System.out::println);

        //two
        List list = Arrays.asList("sa","super");
        Stream stream2 = list.stream();
        stream2.forEach(System.out::println);

        //three
        Stream stream3 = Stream.of("a","b","c");
        stream3.forEach(System.out::println);

        //four
        Stream stream4 = Stream.generate(new Supplier<Double>() {

            @Override
            public Double get() {
                return Math.random();
            }
        }).limit(10);
        stream4.forEach(System.out::println);

        ///five
        Stream stream_5_1 = list.stream();
        Stream stream_5_2 = Arrays.asList(1,3,5,10).stream();
        Stream stream5 = Stream.concat(stream_5_1,stream_5_2);
        stream5.forEach(System.out::println);
        //stream has already been operated upon or closed 一个stream只能使用一次
        //stream5.forEach(System.out::println);
    }
}
