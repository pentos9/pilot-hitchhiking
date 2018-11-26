package com.spacex.hitchhiking.jvm;

public class StackOverFlowErrorTest {
    private int depth = 0;

    public void softMethod() {
        depth++;
        softMethod();
    }

    /**
     * It throws: Exception in thread "main" java.lang.StackOverflowError
     * when recursive counter equals: 18799
     *
     * Environment:
     *
     *     Total bytes: 11,273,403
     *     Total classes: 655
     *     Total instances: 13,011
     *     Classloaders: 3
     *     GC roots: 607
     *     Number of objects pending for finalization: 0
     *
     *     OS: Mac OS X (10.12.6)
     *     Architecture: x86_64 64bit
     *     Java Home: /Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home
     *     Java Version: 11.0.1
     *     JVM: OpenJDK 64-Bit Server VM (11.0.1+13, mixed mode)
     *     Java Vendor: Oracle Corporation
     *
     * @param args
     */
    public static void main(String[] args) {
        StackOverFlowErrorTest testCase = null;
        try {
            testCase = new StackOverFlowErrorTest();
            testCase.softMethod();
        } finally {
            System.out.println("recursive counter:" + testCase.depth);
        }

    }
}
