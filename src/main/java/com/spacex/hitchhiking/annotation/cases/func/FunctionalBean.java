package com.spacex.hitchhiking.annotation.cases.func;

public class FunctionalBean {
    public static <T> void doLogic(T... args) {
        Object[] objects = args;
        if (args != null) {
            for (Object arg : args) {
                System.out.println(arg);
            }
        }
    }
}
