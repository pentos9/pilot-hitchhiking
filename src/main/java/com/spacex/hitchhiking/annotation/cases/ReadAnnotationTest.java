package com.spacex.hitchhiking.annotation.cases;

import com.spacex.hitchhiking.annotation.define.Book;
import com.spacex.hitchhiking.annotation.define.framework.Service;
import com.spacex.hitchhiking.annotation.enums.Priority;
import com.spacex.hitchhiking.annotation.enums.Status;

import java.lang.reflect.Method;

public class ReadAnnotationTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Class<BookTest> magicBook = BookTest.class;
        boolean isAnnotatedWithBook = magicBook.isAnnotationPresent(Book.class);
        if (isAnnotatedWithBook) {
            Book book = magicBook.getAnnotation(Book.class);
            String author = book.author();
            int price = book.price();
            Priority priority = book.priority();
            Status status = book.status();
            System.out.println(String.format("%s,$%s,%s,%s", author, price, priority, status));
        }

        Method[] methods = magicBook.getDeclaredMethods();
        for (Method method : methods) {
            boolean isAnnotatedWithService = method.isAnnotationPresent(Service.class);
            if (isAnnotatedWithService) {
                Service service = method.getAnnotation(Service.class);
                System.out.println(String.format("%s", service.value()));
            }
        }

    }
}
