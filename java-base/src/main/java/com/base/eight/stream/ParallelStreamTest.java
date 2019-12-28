package com.base.eight.stream;

import java.util.Arrays;
import java.util.List;

/**
 * parallelStream 有平行化处理能力，分而治之，将一个大任务分成几个小任务
 * 每个任务进行独立的操作。
 * stream Or parallelStream
 * 1.是否需要并行
 * 2.任务之前是否独立？是否会引起任何竞态条件？
 * 3.结果是否取决于任务的调用顺序？
 */
public class ParallelStreamTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        //无序的打印
        numbers.parallelStream().forEach(System.out::println);
        //有序的打印,但是会失去平行化的一些优势
        numbers.parallelStream().forEachOrdered(System.out::println);
    }
}
