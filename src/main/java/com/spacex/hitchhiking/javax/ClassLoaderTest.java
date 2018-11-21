package com.spacex.hitchhiking.javax;

public class ClassLoaderTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        ClassLoader testClassLoader = ClassLoaderTest.class.getClassLoader();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader == testClassLoader);
        System.out.println(testClassLoader);

        ClassLoader parentClassLoader = classLoader.getParent();
        System.out.println(parentClassLoader);

        ClassLoader parentClassLoaderLevel3 = parentClassLoader.getParent();
        System.out.println(parentClassLoaderLevel3);

        try {
            Class generatorClass = classLoader.loadClass("com.spacex.hitchhiking.generic.generator.RandomeStringGenerator");
            System.out.println(generatorClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
