package com.spacex.hitchhiking.cpu;

public class CpuOverloadTest {
    public static void main(String[] args) {
        run();
    }

    /**
     * cpu load can reach 90% after running
     */
    public static void run() {
        int num = 0;
        while (num <= 0) {
            num = num * 10;
        }
    }
}
