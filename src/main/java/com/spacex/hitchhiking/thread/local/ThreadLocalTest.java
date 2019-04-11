package com.spacex.hitchhiking.thread.local;

import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
    public static void main(String[] args) {
        run();
    }

    // Java8
    // -XX:+PrintGCDetails -Xms100m -Xmx100m
    // Because the entry in ThreadLocalMap extends WeakReference,
    // the entry will be GC after ThreadLocal object is GC
    // no memory leak indeed
    public static void run() {
        long total = 2000000000;
        for (long index = 0; index < total; index++) {
            // give GC some time
            if (index % 10000 == 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ThreadLocal<Element> threadLocal = new ThreadLocal<>();
            threadLocal.set(new Element(index));
        }
    }

    public static class Element {
        private long value;

        public Element(long value) {
            this.value = value;
        }

        public void finalize() {
            System.out.println(value);
        }

        @Override
        public String toString() {
            return "Element{" +
                    "value=" + value +
                    '}';
        }
    }
}
