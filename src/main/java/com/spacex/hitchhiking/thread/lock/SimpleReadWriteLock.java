package com.spacex.hitchhiking.thread.lock;

public class SimpleReadWriteLock {

    private int writeCount = 0;

    private int readCount = 0;

    /**
     * 获取读锁,读锁在写锁不存在的时候才能获取
     *
     * @throws InterruptedException
     */
    public synchronized void lockRead() throws InterruptedException {

        //写锁存在的时候，需要wait
        while (writeCount > 0) {
            wait();
        }

        readCount++;
    }

    /**
     * 释放读锁
     */
    public synchronized void unlockRead() {
        readCount--;
        notifyAll();
    }

    /**
     * 获取写锁,当读锁存在时需要wait.
     */
    public synchronized void lockWrite() throws InterruptedException {

        // 先判断是否有写请求
        while (writeCount > 0) {
            wait();
        }

        writeCount++;

        // 读锁为0时获取写锁
        while (readCount > 0) {
            wait();
        }
    }

    /**
     * 释放写锁
     */
    public synchronized void releaseWrite() {
        writeCount--;
        notifyAll();
    }


}
