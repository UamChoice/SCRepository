package com.base.eight.BigDecimal;

import java.math.BigDecimal;

public class Persion {
    private String name;
    private BigDecimal weight;
    public Persion(String name, BigDecimal weight) {
        this.name = name;
        this.weight = weight;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getWeight() {
        return weight;
    }
}
