package com.base.eight.stream;

import com.base.dto.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StreamSorted {
    /**
     * List 和 Set是一样的操作
     * @param args
     */
    public static void main(String[] args) {
        sortedList();
        sortedMap();
        mapSorted();
    }

    public static void sortedList(){
        List<Student> list = new ArrayList<Student>();
        list.add(new Student(1, "Mahesh", 12));
        list.add(new Student(2, "Suresh", 15));
        list.add(new Student(3, "Nilesh", 10));

        System.out.println("---Natural Sorting by Name---");
        List<Student> slist = list.stream().sorted().collect(Collectors.toList());
        slist.forEach(e -> System.out.println(e));

        System.out.println("---Natural Sorting by Name in reverse order---");
        slist = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        slist.forEach(System.out::println);

        System.out.println("---Sorting using Comparator by Age---");
        slist = list.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        slist.forEach(System.out::println);

        System.out.println("---Sorting using Comparator by Age with reverse order---");
        slist = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        slist.forEach(System.out::println);
    }

    public static void sortedMap(){
        Map<Integer, String> map = new HashMap<>();
        map.put(15, "Mahesh");
        map.put(10, "Suresh");
        map.put(30, "Nilesh");

        System.out.println("---Sort by Map Value---");
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(e -> System.out.println("Key: "+ e.getKey() +", Value: "+ e.getValue()));

        System.out.println("---Sort by Map Key reversed---");
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> System.out.println("Key: "+ e.getKey() +", Value: "+ e.getValue()));
    }

    public static void mapSorted(){
        Map<Integer, Student> map = new HashMap<>();
        map.put(1, new Student(1, "Mahesh", 12));
        map.put(2, new Student(2, "Suresh", 15));
        map.put(3, new Student(3, "Nilesh", 10));
        //Map Sorting by Value i.e student's natural ordering i.e by name
        System.out.println("Map Sorting by Value i.e student's natural ordering i.e by name");
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(e -> {
                    Integer key = (Integer)e.getKey();
                    Student std = (Student)e.getValue();
                    System.out.println("Key: " + key +", value: ("+ std.getId() +", "+ std.getName()+", "+ std.getAge()+")");
                });
    }
}
