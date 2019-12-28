package com.base.object;

public class Cat extends Animal{

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public String owner() {
        return "小青";
    }
}
