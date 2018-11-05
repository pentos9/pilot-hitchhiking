package com.spacex.hitchhiking.annotation.cases;

import com.spacex.hitchhiking.annotation.define.Book;
import com.spacex.hitchhiking.annotation.enums.Priority;
import com.spacex.hitchhiking.annotation.enums.Status;

public class CreateAnnotationTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        try {
            Class clazz = Class.forName("com.spacex.hitchhiking.annotation.cases.BookTest");
            Book book = (Book) clazz.getAnnotation(Book.class);
            String author = book.author();
            int price = book.price();
            Priority priority = book.priority();
            Status status = book.status();
            System.out.println(String.format("%s,%s,%s,%s", author, price, priority, status));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
