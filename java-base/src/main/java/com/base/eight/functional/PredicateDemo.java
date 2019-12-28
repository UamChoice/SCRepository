package com.base.eight.functional;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        whatIsFunctionCompile();
    }

    public static void whatIsFunctionCompile(){
        predicate();
    }

    public static void predicate(){
        Predicate<String> p = o -> o.equals("test");
        Predicate<Integer> gp = o -> o.intValue()>10;

        System.out.println(p.negate().test("test"));;
        System.out.println(gp.test(12));
    }
}
