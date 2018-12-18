package com.spacex.hitchhiking.aop.cglib;

import com.spacex.hitchhiking.util.PrintUtil;

public class BookServiceWithoutInterfaceImpl {
    public void add() {
        PrintUtil.println("BookServiceWithoutInterfaceImpl#add book ...");
    }

    public void delete() {
        PrintUtil.println("BookServiceWithoutInterfaceImpl#delete book ...");
    }
}
