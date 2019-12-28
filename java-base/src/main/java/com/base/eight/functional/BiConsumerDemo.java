package com.base.eight.functional;

import java.util.function.BiConsumer;

public class BiConsumerDemo {
    public static void main(String[] args) {
        BiConsumer biConsumer = (x,y)-> System.out.println(x+","+y);
        //xiaoming,hi
        biConsumer.accept("xiaoming","hi");
    }
}
