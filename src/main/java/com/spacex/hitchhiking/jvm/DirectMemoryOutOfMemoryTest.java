package com.spacex.hitchhiking.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectMemoryOutOfMemoryTest {
    public static void main(String[] args) {
        run();
    }

    /**
     * VM Args:-Xms20m -Xmx20m -XX:MaxDirectMemorySize=10m
     *
     * Open JDK 11:
     * counter:13420755
     *
     * java(4770,0x104755000) malloc: *** mach_vm_map(size=10485760) failed (error code=3)
     *
     * *** error: can't allocate region
     * *** set a breakpoint in malloc_error_break to debug
     * Exception in thread "main" java.lang.OutOfMemoryError
     * 	at java.base/jdk.internal.misc.Unsafe.allocateMemory(Unsafe.java:616)
     * 	at jdk.unsupported/sun.misc.Unsafe.allocateMemory(Unsafe.java:462)
     * 	at com.spacex.hitchhiking.jvm.DirectMemoryOutOfMemoryTest.run(DirectMemoryOutOfMemoryTest.java:22)
     * 	at com.spacex.hitchhiking.jvm.DirectMemoryOutOfMemoryTest.main(DirectMemoryOutOfMemoryTest.java:9)
     */
    public static void run() {
        int counter = 0;
        try {
            Field field = Unsafe.class.getDeclaredFields()[0];
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get(null);
            while (true) {
                unsafe.allocateMemory(1024 * 1024 * 10);
                counter++;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            System.out.println("counter:" + counter);
        }
    }
}
