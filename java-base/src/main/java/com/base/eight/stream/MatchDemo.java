package com.base.eight.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MatchDemo {
    public static void main(String[] args) {
        Predicate<EmployeeDemo> p1 = e -> e.id < 10 && e.name.startsWith("A");
        Predicate<EmployeeDemo> p2 = e -> e.sal < 10000;
        List<EmployeeDemo> list = EmployeeDemo.getEmpList();
        //using allMatch
        boolean b1 = list.stream().allMatch(p1);
        System.out.println(b1);
        boolean b2 = list.stream().allMatch(p2);
        System.out.println(b2);
        //using anyMatch
        boolean b3 = list.stream().anyMatch(p1);
        System.out.println(b3);
        boolean b4 = list.stream().anyMatch(p2);
        System.out.println(b4);
        //using noneMatch
        boolean b5 = list.stream().noneMatch(p1);
        System.out.println(b5);

    }
}
class EmployeeDemo{
    public int id;
    public String name;
    public int sal;
    public EmployeeDemo(int id,String name,int sal  ){
        this.id = id;
        this.name = name;
        this.sal = sal;
    }
    public static List<EmployeeDemo> getEmpList(){
        List<EmployeeDemo> list = new ArrayList<>();
        list.add(new EmployeeDemo(1, "A", 2000));
        list.add(new EmployeeDemo(2, "B", 3000));
        list.add(new EmployeeDemo(3, "C", 4000));
        list.add(new EmployeeDemo(4, "D", 5000));
        return list;
    }
}
