package com.spacex.hitchhiking.javax;

import com.spacex.hitchhiking.util.PrintUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoadingWithReflectionTest {
    public static void main(String[] args) {
        run();
    }


    public static void testMethod(String message) {
        if (message == null) {
            message = "default test message";
        }
        PrintUtil.println("ClassLoadingWithReflectionTest#testMethod" + message);
    }


    /**
     * VM Args:
     * -XX:+TraceClassLoading
     */
    public static void run() {
        try {
            Class clazz = Class.forName("com.spacex.hitchhiking.javax.ClassLoadingWithReflectionTest");
            Object testObject = clazz.newInstance();
            Method method = clazz.getMethod("testMethod", String.class);
            method.invoke(testObject, "TraceClassLoading");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
