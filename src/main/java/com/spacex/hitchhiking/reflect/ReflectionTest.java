package com.spacex.hitchhiking.reflect;

import com.spacex.hitchhiking.reflect.bean.Song;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Class songClass = Song.class;
        Method[] methods = songClass.getDeclaredMethods();
        Field[] fields = songClass.getDeclaredFields();
        Constructor[] constructors = songClass.getConstructors();
        Annotation[] annotations = songClass.getAnnotations();

        printInfo("Method", methods);
        printInfo("Field", fields);
        printInfo("Constructor", constructors);
        printInfo("Annotation", annotations);
    }


    public static <T> void printInfo(String title, T[] objects) {
        System.out.println(String.format("###### %s ####", title));
        for (T object : objects) {
            System.out.println(object);
        }
    }
}
