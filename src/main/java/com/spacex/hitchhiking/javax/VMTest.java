package com.spacex.hitchhiking.javax;

public class VMTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long initMemory = runtime.freeMemory();
        runtime.gc();
        long endMemory = runtime.freeMemory();
        System.out.println((initMemory - endMemory) / (1024 * 1024));

        System.out.println((totalMemory - endMemory) / (1024 * 1024));
    }
}
