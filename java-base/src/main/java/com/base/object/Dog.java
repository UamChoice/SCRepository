package com.base.object;

public class Dog extends Animal{
    public Dog() {
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void eat() {
        System.out.println(name+"狗吃骨头");
    }

    @Override
    public String owner() {
        return "小白";
    }

    public void getParentInfo(){
        System.out.println("父类信息"+super.name+"，"+super.age);
    }
}
