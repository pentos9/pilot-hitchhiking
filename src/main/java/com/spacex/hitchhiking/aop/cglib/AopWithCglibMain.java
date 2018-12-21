package com.spacex.hitchhiking.aop.cglib;

public class AopWithCglibMain {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        BookServiceCglib bookServiceCglib = new BookServiceCglib();
        BookServiceWithoutInterfaceImpl bookServiceWithoutInterface = (BookServiceWithoutInterfaceImpl) bookServiceCglib.getInstance(new BookServiceWithoutInterfaceImpl());
        bookServiceWithoutInterface.add();
        bookServiceWithoutInterface.delete();
    }
}
