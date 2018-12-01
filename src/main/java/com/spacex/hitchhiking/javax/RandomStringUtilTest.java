package com.spacex.hitchhiking.javax;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class RandomStringUtilTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        testPhoneWithMosaic("89567891234");
        testPhoneWithMosaic("8956");
        testPhoneWithMosaic("89765421");
    }

    public static void testRandomString() {
        System.out.println(RandomStringUtils.random(16, true, false));
        System.out.println(RandomStringUtils.random(32, true, false));
        System.out.println(RandomStringUtils.random(6, false, true));
    }

    public static void testPhoneWithMosaic(String phone) {
        if (StringUtils.isBlank(phone)) {
            return;
        }
        String phoneWithMosaic = phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        System.out.println(phoneWithMosaic);
    }
}
