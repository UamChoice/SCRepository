package com.base.eight.stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class MapToList {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(111, "Lalkrishna");
        map.put(154, "Atal");
        map.put(30, "Narendra");
        map.put(200, "Amit");

        List<User> list = map.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey()))
                .map(e -> new User(e.getKey(), e.getValue())).collect(Collectors.toList());

        list.forEach(l -> System.out.println("Id: "+ l.getId()+", Name: "+ l.getName()));

        // List 转 Map
        Map map1 = list.stream().collect(Collectors.toMap(User::getId,User::getName));
        map1.forEach((k,v)->{
            System.out.println("k="+k+",value="+v);
        });
    }
}
class User {
    private int id;
    private String name;
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
