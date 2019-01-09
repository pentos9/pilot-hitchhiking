package com.spacex.hitchhiking.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        try {
            readLock.lock();
            doJob();
        } finally {
            readLock.unlock();
        }
    }

    public static void doJob() {

    }
}
