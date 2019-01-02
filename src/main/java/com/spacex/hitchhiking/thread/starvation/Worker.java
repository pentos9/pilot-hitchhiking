package com.spacex.hitchhiking.thread.starvation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Worker {
    public synchronized void doJob() {
        String name = Thread.currentThread().getName();
        String fileName = name + ".txt";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            bufferedWriter.write("Thread " + name + " wrote this message!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println(name + " is working!");
        }
    }
}
