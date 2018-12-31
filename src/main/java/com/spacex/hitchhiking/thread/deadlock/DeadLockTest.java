package com.spacex.hitchhiking.thread.deadlock;

import com.spacex.hitchhiking.util.PrintUtil;

public class DeadLockTest {
    public static void main(String[] args) {
        DeadLockTest deadLockTest = new DeadLockTest();
        deadLockTest.run();
    }

    public void run() {
        Thread worker = new Thread(() -> {
            this.first();
        }, "worker-1");

        Thread worker2 = new Thread(() -> {
            this.second();

        }, "worker-2");

        worker.start();
        worker2.start();
    }

    public void first() {
        synchronized (Integer.class) {
            PrintUtil.println(Thread.currentThread().getName() + "|" + "DeadLockTest#first Integer.class lock and try to get String.class lock ...");
            synchronized (String.class) {
                System.out.println(Thread.currentThread().getName() + "|" + "DeadLockTest#first String.class lock...");
                doJob();
            }
        }
    }

    public void second() {
        synchronized (String.class) {
            PrintUtil.println(Thread.currentThread().getName() + "|" + "DeadLockTest#second String.class lock and try to get Integer.class lock ...");
            synchronized (Integer.class) {
                System.out.println(Thread.currentThread().getName() + "|" + "DeadLockTest#second Integer.class lock ...");
                doJob();
            }
        }
    }

    private void doJob() {
        try {
            PrintUtil.println("doJob");
            Thread.sleep(3000L);
            PrintUtil.println("Job finished!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * VisualVM profiler or using jstack utility
     *
     * I execute: jstack -pid and got the following info:
     *
     * Found one Java-level deadlock:
     * =============================
     * "worker-1":
     *   waiting to lock monitor 0x00007fcae8036500 (object 0x0000000787f00980, a java.lang.Class),
     *   which is held by "worker-2"
     * "worker-2":
     *   waiting to lock monitor 0x00007fcae8037300 (object 0x0000000787f04808, a java.lang.Class),
     *   which is held by "worker-1"
     *
     * Java stack information for the threads listed above:
     * ===================================================
     * "worker-1":
     * 	at com.spacex.hitchhiking.thread.deadlock.DeadLockTest.first(DeadLockTest.java:29)
     * 	- waiting to lock <0x0000000787f00980> (a java.lang.Class for java.lang.String)
     * 	- locked <0x0000000787f04808> (a java.lang.Class for java.lang.Integer)
     * 	at com.spacex.hitchhiking.thread.deadlock.DeadLockTest.lambda$run$0(DeadLockTest.java:11)
     * 	at com.spacex.hitchhiking.thread.deadlock.DeadLockTest$$Lambda$1/0x0000000800060c40.run(Unknown Source)
     * 	at java.lang.Thread.run(java.base@11.0.1/Thread.java:834)
     * "worker-2":
     * 	at com.spacex.hitchhiking.thread.deadlock.DeadLockTest.second(DeadLockTest.java:40)
     * 	- waiting to lock <0x0000000787f04808> (a java.lang.Class for java.lang.Integer)
     * 	- locked <0x0000000787f00980> (a java.lang.Class for java.lang.String)
     * 	at com.spacex.hitchhiking.thread.deadlock.DeadLockTest.lambda$run$1(DeadLockTest.java:17)
     * 	at com.spacex.hitchhiking.thread.deadlock.DeadLockTest$$Lambda$2/0x0000000800061040.run(Unknown Source)
     * 	at java.lang.Thread.run(java.base@11.0.1/Thread.java:834)
     *
     * Found 1 deadlock.
     */
}
