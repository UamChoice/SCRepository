package com.base.eight.functional;

import java.util.function.BiFunction;

public class BiFunctionDemo {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> biFunction = (a,b) -> a+b;
        int a = biFunction.apply(9,8);
        System.out.println(a);
    }
}
