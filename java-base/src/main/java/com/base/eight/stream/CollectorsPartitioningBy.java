package com.base.eight.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsPartitioningBy {
    public static void main(String[] args) {
        StudentThis s1 = new StudentThis("Ram", 18);
        StudentThis s2 = new StudentThis("Shyam",22);
        StudentThis s3 = new StudentThis("Mohan",19);
        StudentThis s4 = new StudentThis("Mahesh",20);
        StudentThis s5 = new StudentThis("Krishna",21);
        List<StudentThis> list = Arrays.asList(s1,s2,s3,s4,s5);
        //partition of Student on the basis of age
        System.out.println("----Partition of Student on the basis of age >20 ----");
        Map<Boolean, List<StudentThis>> stdByClass = list.stream()
                .collect(Collectors.partitioningBy(s -> s.getAge() > 20));

        stdByClass.forEach((k,v)->System.out.println("Key:"+k+"  "+
                ((List<StudentThis>)v).stream().map(s->s.getName()).collect(Collectors.joining(","))));
    }
}
class StudentThis {
    private String name;
    private int age;
    public StudentThis(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}