package com.spacex.hitchhiking.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConstantPoolOutOfMemoryTest {
    public static void main(String[] args) {
        run();
    }

    /**
     * Experiment 1:
     * Java 8: it doesn't throw any exception
     * VM Args:-XX:PermSize=10m -XX:MaxPermSize=10m
     * <p>
     * Experiment 2:
     * VM Args:-Xms5m -Xmx5m
     * <p>
     * Java 8: it throws: Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     */
    public static void run() {
        List<String> list = new ArrayList<>();
        int counter = 1;
        try {
            while (true) {
                list.add(UUID.randomUUID().toString().intern());
                counter++;
            }
        } finally {
            System.out.println("counter:" + counter);
        }

    }
}
