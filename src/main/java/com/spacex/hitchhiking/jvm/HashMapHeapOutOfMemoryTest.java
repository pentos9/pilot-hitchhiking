package com.spacex.hitchhiking.jvm;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.HashSet;
import java.util.Set;

public class HashMapHeapOutOfMemoryTest {
    public static void main(String[] args) {
        //bloomFilter();
        run();
    }

    /**
     * It throws:
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     */
    public static void run() {
        Set<Integer> hashSet = new HashSet<>();
        int max = 10000000;
        for (int i = 0; i < max; i++) {
            hashSet.add(i);
        }

        System.out.println(hashSet.contains(1000000));
        System.out.println(hashSet.contains(2));
        System.out.println(hashSet.contains(3));
    }

    /**
     * VM Args:
     * -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps(OpenJDK 11,not support this Args)
     */
    public static void bloomFilter() {
        int max = 100000000;
        BloomFilter bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 10000000, 0.01);
        for (int i = 0; i < max; i++) {
            bloomFilter.put(i);
        }


        System.out.println(bloomFilter.mightContain(-1));
        System.out.println(bloomFilter.mightContain(50000000));
    }
}
