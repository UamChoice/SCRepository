package com.base.eight.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concat {
    public static void main(String[] args) {
        //数组的concat
        arrayConcat();

        //list set concat
        listConcat();
    }

    public static void arrayConcat(){
        Book[] bk1 = new Book[3];
        Book[] bk2 = new Book[3];
        {
            bk1[0] = new Book("A",1);
            bk1[1] = new Book("B",11);
            bk1[2] = new Book("C",111);

            bk2[0] = new Book("A",1);
            bk2[1] = new Book("B",11);
            bk2[2] = new Book("C",111);
        }
        Book[] bks = (Book[]) Stream.concat(Stream.of(bk1),Stream.of(bk2)).distinct().toArray(b-> new Book[b]);

        for(Book book : bks){
            System.out.println(book);
        }
    }

    public static void listConcat(){
        List<Book> b1 = BookFactory.getList1();
        List<Book> b2 = BookFactory.getList2();
        List<Book> books = Stream.concat(b1.stream(),b2.stream()).distinct().collect(Collectors.toList());
        books.forEach(System.out::println);
    }
}
