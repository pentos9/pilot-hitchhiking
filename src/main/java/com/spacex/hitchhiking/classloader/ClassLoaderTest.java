package com.spacex.hitchhiking.classloader;

import com.spacex.hitchhiking.util.PrintUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        run();
    }

    public static void run() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        final String targetClassName = "com.spacex.hitchhiking.classloader.Car";
        String classFilePath = "/Users/lucas/projects/pilot-hitchhiking/src/main/java/com/spacex/hitchhiking/classloader/Car.class.1";
        ClassLoader classLoader = getClassLoader(targetClassName, classFilePath);

        Object car1 = classLoader.loadClass(targetClassName).newInstance();
        car1.getClass().getMethod("run").invoke(car1);

        classFilePath = "/Users/lucas/projects/pilot-hitchhiking/src/main/java/com/spacex/hitchhiking/classloader/Car.class.2";
        ClassLoader classLoader2 = getClassLoader(targetClassName, classFilePath);

        Object car2 = classLoader2.loadClass(targetClassName).newInstance();
        car2.getClass().getMethod("run").invoke(car2);

        printInstanceDetail(car1, car2);
        printClassDetail(classLoader, classLoader2);
    }

    private static ClassLoader getClassLoader(String targetClassName, String classFilePath) throws ClassNotFoundException {
        return new ClassLoader() {
            @Override
            public Class<?> loadClass(String className) throws ClassNotFoundException {
                try {
                    if (className.equals(targetClassName)) {
                        byte[] classBytes = Files.readAllBytes(Paths.get(classFilePath));
                        return defineClass(className, classBytes, 0, classBytes.length);
                    } else {
                        return super.loadClass(className);
                    }
                } catch (IOException e) {
                    throw new ClassNotFoundException(className);
                }
            }
        };
    }

    public static void printInstanceDetail(Object... objects) {
        if (ArrayUtils.isEmpty(objects)) {
            return;
        }

        PrintUtil.println("###printInstanceDetail###");

        for (Object object : objects) {
            System.out.println(object.hashCode());
        }

        for (Object object : objects) {
            System.out.println(object.getClass());
        }

        for (Object object : objects) {
            System.out.println(object.getClass().getClassLoader());
        }

    }

    public static void printClassDetail(ClassLoader... classLoaders) {
        if (ArrayUtils.isEmpty(classLoaders)) {
            return;
        }

        PrintUtil.println("###printClassDetail###");

        for (ClassLoader classLoader : classLoaders) {
            System.out.println(classLoader);
        }


        for (ClassLoader classLoader : classLoaders) {
            System.out.println(classLoader.getParent().getParent().getParent());
            System.out.println(classLoader.getParent().getParent());
            System.out.println(classLoader.getParent());
            System.out.println(classLoader);
        }

    }
}
