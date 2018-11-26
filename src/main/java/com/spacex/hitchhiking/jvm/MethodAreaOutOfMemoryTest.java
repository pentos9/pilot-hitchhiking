package com.spacex.hitchhiking.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MethodAreaOutOfMemoryTest {

    public static void main(String[] args) {
        run();
    }

    /**
     * -XX:MetaspaceSize=28m -XX:MaxMetaspaceSize=28m
     * <p>
     * Java8: Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
     * Java11: Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "main"
     */
    public static void run() {
        int counter = 0;
        try {
            while (true) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMObject.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(obj, args);
                    }
                });
                enhancer.create();
                counter++;
            }
        } finally {
            System.out.println("counter:" + counter);
        }
    }


    static class OOMObject {

    }
}
