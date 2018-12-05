package com.spacex.hitchhiking.javax;

import com.spacex.hitchhiking.javax.cglib.CglibProxy;
import com.spacex.hitchhiking.javax.cglib.interfaces.UserService;
import com.spacex.hitchhiking.javax.cglib.interfaces.UserServiceImpl;


public class CglibProxyTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        testPerformance();
    }

    public static void testCglib(int count) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            UserServiceImpl userServiceImpl = new UserServiceImpl();
            CglibProxy cglibProxy = new CglibProxy();
            UserService proxy = (UserService) cglibProxy.getProxy(userServiceImpl.getClass());
            proxy.add("Knight");
        }

        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
    }

    public static void testDirectInvoke(int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            UserServiceImpl userServiceImpl = new UserServiceImpl();
            userServiceImpl.add("Knight");
        }
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
    }

    /**
     * Environment:
     * Open JDK 11
     * <p>
     * OS:
     * macOS 10.12.6
     * <p>
     * Hardware:
     * 2.7 GHz Intel Core i5
     * 8 GB 1867 MHz DDR3
     */
    public static void testPerformance() {
        int count = 10000000;// one million
        testCglib(count);
        testDirectInvoke(count);
    }
}
