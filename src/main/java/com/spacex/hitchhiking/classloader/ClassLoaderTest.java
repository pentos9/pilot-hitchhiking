package com.spacex.hitchhiking.classloader;

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

        Object object = classLoader.loadClass(targetClassName).newInstance();
        object.getClass().getMethod("run").invoke(object);

        classFilePath = "/Users/lucas/projects/pilot-hitchhiking/src/main/java/com/spacex/hitchhiking/classloader/Car.class.2";
        ClassLoader classLoader2 = getClassLoader(targetClassName, classFilePath);

        Object object1 = classLoader2.loadClass(targetClassName).newInstance();
        object1.getClass().getMethod("run").invoke(object1);
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
}
