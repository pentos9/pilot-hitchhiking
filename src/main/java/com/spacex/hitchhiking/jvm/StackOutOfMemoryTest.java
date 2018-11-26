package com.spacex.hitchhiking.jvm;

public class StackOutOfMemoryTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        StackOutOfMemoryTest stackOutOfMemoryTest = new StackOutOfMemoryTest();
        stackOutOfMemoryTest.outOfMemoryMethod();
    }

    public void outOfMemoryMethod() {
        while (true) {
            new Thread(() -> {
                loopMethod();
            }).start();
        }
    }

    public void loopMethod() {
        while (true) {
            System.out.println("do something");
        }
    }
}
