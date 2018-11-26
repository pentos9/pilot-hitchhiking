package com.spacex.hitchhiking.jvm;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryTest {
    public static void main(String[] args) {
        run();
    }

    /**
     * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     */
    public static void run() {
        List<byte[]> byteList = new ArrayList<>();
        int counter = 1;
        while (true) {
            byteList.add(new byte[10 * 1024 * 1024]);
            System.out.println("alloc counter:" + counter++);
        }
    }
}
