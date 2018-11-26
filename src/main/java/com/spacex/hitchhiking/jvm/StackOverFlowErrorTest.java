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
     * openjdk version "11.0.1" 2018-10-16
     * OpenJDK Runtime Environment 18.9 (build 11.0.1+13)
     * OpenJDK 64-Bit Server VM 18.9 (build 11.0.1+13, mixed mode)
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
