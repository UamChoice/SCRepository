package com.base.eight.stream;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

/**
 * Reduce中文含义为：减少、缩小；而Stream中的Reduce方法干的正是这样的活：
 * 根据一定的规则将Stream中的元素进行计算后返回一个唯一的值。
 */
public class ReduceDemo {
    public static void main(String[] args) {
        int[] array = {23,43,56,97,32};
        System.out.println("--Using IntStream.sum()--");
        int sum = Arrays.stream(array).sum();
        //251 即所有数字加和
        System.out.println(sum);
        System.out.println("--Using Stream.reduce() with IntBinaryOperator--");
        IntBinaryOperator ibop = (x, y) -> x+y;
        sum = Arrays.stream(array).reduce(0, ibop);
        System.out.println(sum);
        System.out.println("--Using Stream.reduce() with Integer.sum()--");
        sum = Arrays.stream(array).reduce(0, Integer::sum);
        //251 即所有数字加和
        System.out.println(sum);
        System.out.println("--Using custom method--");
        sum = Arrays.stream(array).reduce(0, StatisticsUtility::addIntData);
        //251 即所有数字加和
        System.out.println(sum);

        System.out.println("--Using 第一个参数作用--");
        sum = Arrays.stream(array).reduce(10, StatisticsUtility::addIntData);
        //261 即所有数字加和 再加上 第一个参数 10
        System.out.println(sum);
    }
}
