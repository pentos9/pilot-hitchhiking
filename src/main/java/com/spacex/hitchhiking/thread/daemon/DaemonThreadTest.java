package com.spacex.hitchhiking.thread.daemon;

public class DaemonThreadTest {
    public static void main(String[] args) {
        run(args);

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void run(String[] args) {
        Thread worker = new Thread(() -> {
            int count = 0;
            while (true) {
                System.out.println("[Worker] do job ... " + count++);

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //When all non-daemon threads finish, the JVM halts, and any remaining daemon threads are abandoned
                    System.out.println("this is always should be run!");
                }
            }

        });

        worker.setDaemon(true);
        worker.start();
    }
}
