package com.base.object;

public abstract class Animal {
    public String name = "animal";
    public int age = 1;

    public Animal() {
//        System.out.println("动物类构造:"+name+","+age);
    }

    //动物吃
    public abstract void eat();

    //主人
    public abstract String owner();

    //宠物信息
    public void getInfo(){
        System.out.println("my name is "+name+",my age is "+age+",my owner is "+owner());
    }
}
