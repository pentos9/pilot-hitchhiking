package com.spacex.hitchhiking.javax;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtilTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println(RandomStringUtils.random(16, true, false));
        System.out.println(RandomStringUtils.random(32, true, false));
        System.out.println(RandomStringUtils.random(6, false, true));
    }
}
