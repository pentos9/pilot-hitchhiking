package com.spacex.hitchhiking.thread.starvation;

public class StarvationTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Worker worker = new Worker();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                worker.doJob();
            });
            thread.start();
        }
    }
}
