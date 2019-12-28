package com.base.eight.functional;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        consumer();
    }

    public static void consumer(){
        Consumer c = (s) -> System.out.println(s+"_add_print");
        Consumer c1 = System.out::println;

        c.andThen(c1).accept("first");
        c1.andThen(c).accept("second");
        c.andThen(c).andThen(c).andThen(c).accept("third");
    }
}
