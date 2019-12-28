package com.base.math;

import com.base.eight.BigDecimal.Persion;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class BigDecimalSumUse {
    public static void main(String[] args) {
        Persion p1 = new Persion("AAA", new BigDecimal("-45.23"));
        Persion p2 = new Persion("BBB", new BigDecimal("-55.43"));
        Persion p3 = new Persion("CCC", new BigDecimal("-65.21"));
        Persion p4 = new Persion("DDD", new BigDecimal("-35.73"));
        List<Persion> list = Arrays.asList(p1, p2, p3, p4);
        BigDecimal sum = list.stream().map(Persion::getWeight)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);

        sum = list.stream().map(p -> p.getWeight())
                .reduce(BigDecimal.ZERO, (b1, b2) -> b1.add(b2));
        System.out.println(sum);

        sum = list.stream().map(Persion::getWeight)
                .reduce(BigDecimal.ZERO, Utility::addWeight);
        System.out.println(sum);

    }
}

class Utility {
    public static BigDecimal addWeight(BigDecimal w1, BigDecimal w2) {
        return w1.add(w2);
    }
}
