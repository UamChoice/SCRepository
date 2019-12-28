package com.base.object;

public class Run {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.name="dog_one";
        animal.age=3;
        animal.eat();
        animal.getInfo();

        Dog dog = new Dog();
        dog.age=2;
        dog.name="dog_two";
        dog.eat();
        dog.getInfo();
        dog.getParentInfo();

        Cat cat = new Cat();
        cat.name="汤姆cat";
        cat.age=8;
        cat.eat();
        cat.getInfo();
    }
}
