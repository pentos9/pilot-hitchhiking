package com.spacex.hitchhiking.reflect;

import java.lang.reflect.Array;

public class ArrayReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException {
        run();
    }

    public static void run() throws ClassNotFoundException {
        Object array = Array.newInstance(String.class, 10);
        Array.set(array, 0, "brad");
        Array.set(array, 1, "pitt");
        System.out.println(Array.get(array, 0));

        Integer[] numbers = new Integer[10];
        Class integerArrayComponentType = numbers.getClass().getComponentType();
        System.out.println(integerArrayComponentType);

        Class longClass = long.class;
        System.out.println(longClass.getName());

        Class stringArrayClass = Class.forName("[Ljava.lang.String;");
        System.out.println(stringArrayClass);
    }
}
