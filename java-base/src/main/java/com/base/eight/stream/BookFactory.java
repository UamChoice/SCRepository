package com.base.eight.stream;

import java.util.ArrayList;
import java.util.List;

public class BookFactory {
    public static List<Book> getList1(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Java",123));
        books.add(new Book("Python",222));
        books.add(new Book("C++",444));
        return books;
    }

    public static List<Book> getList2(){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("数学",123));
        books.add(new Book("语文",222));
        books.add(new Book("英语",444));
        return books;
    }
}
