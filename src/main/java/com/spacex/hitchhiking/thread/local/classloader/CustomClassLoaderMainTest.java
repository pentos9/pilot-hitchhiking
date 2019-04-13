package com.spacex.hitchhiking.thread.local.classloader;

import java.net.URL;

public class CustomClassLoaderMainTest {
    public static void main(String[] args) throws Exception {
        run();
    }

    public static void run() throws Exception {
        loadFoo();
        while (true) {
            System.gc();
            Thread.sleep(1000);
        }
    }

    private static void loadFoo() throws Exception {
        CustomClassLoader cl = new CustomClassLoader(new URL("file:/Users/lucas/projects/pilot-hitchhiking/target/classes/com/spacex/hitchhiking/thread/local"));
        Class<?> clazz = cl.loadClass("CustomClassLoaderMainTest$Foo");// test CustomClassLoaderMainTest$Foo2
        clazz.newInstance();
        cl = null;
    }

    public static class Foo {
        private static final ThreadLocal<Foo> tl = new ThreadLocal<Foo>();

        public Foo() {
            tl.set(this);
            System.out.println("ClassLoader: " + this.getClass().getClassLoader());
        }
    }

    public static class Foo2 {
        private static final ThreadLocal<Integer> tl = new ThreadLocal<Integer>();

        public Foo2() {
            tl.set(42);
            System.out.println("ClassLoader: " + this.getClass().getClassLoader());
        }
    }
}
