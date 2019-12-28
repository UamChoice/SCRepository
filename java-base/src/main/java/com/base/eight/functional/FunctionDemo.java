package com.base.eight.functional;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        function();
    }
    public static void function(){
        Function<Integer,Integer> function = s -> 2 * s;
        Function<Integer,Integer> function1 = s -> s * s;

        //50
        System.out.println(function.compose(function1).apply(5));;
    }
}
