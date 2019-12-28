package com.base.eight.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByDemo {
    public static void main(String[] args) {
        StudentGroup s1 = new StudentGroup("Ram", "A", 20);
        StudentGroup s2 = new StudentGroup("Shyam", "B", 22);
        StudentGroup s3 = new StudentGroup("Mohan", "A", 22);
        StudentGroup s4 = new StudentGroup("Mahesh", "C", 20);
        StudentGroup s5 = new StudentGroup("Krishna", "B", 21);
        List<StudentGroup> list = Arrays.asList(s1,s2,s3,s4,s5);
        //Group StudentGroup on the basis of ClassName
        System.out.println("----Group StudentGroup on the basis of ClassName----");
        Map<String, List<StudentGroup>> stdByClass = list.stream()
                .collect(Collectors.groupingBy(StudentGroup::getClassName));

        stdByClass.forEach((k,v)->System.out.println("Key:"+k+"  "+
                ((List<StudentGroup>)v).stream().map(m->m.getName()).collect(Collectors.joining(","))));

        //Group StudentGroup on the basis of age
        System.out.println("----Group StudentGroup on the basis of age----");
        Map<Integer, List<StudentGroup>> stdByAge = list.stream()
                .collect(Collectors.groupingBy(StudentGroup::getAge));

        stdByAge.forEach((k,v)->System.out.println("Key:"+k+"  "+
                ((List<StudentGroup>)v).stream().map(m->m.getName()).collect(Collectors.joining(","))));
    }
}
class StudentGroup {
    private String name;
    private int age;
    private String className;
    public StudentGroup(String name,String className,int age){
        this.name=name;
        this.age=age;
        this.className = className;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getClassName() {
        return className;
    }
} 