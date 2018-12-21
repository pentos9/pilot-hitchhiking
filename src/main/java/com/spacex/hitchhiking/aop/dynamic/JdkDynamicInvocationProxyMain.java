package com.spacex.hitchhiking.aop.dynamic;

import com.spacex.hitchhiking.aop.dynamic.handler.LogInvocationHandler;
import com.spacex.hitchhiking.aop.dynamic.interfaces.IBusiness;
import com.spacex.hitchhiking.aop.dynamic.interfaces.IBusiness2;

import java.lang.reflect.Proxy;

public class JdkDynamicInvocationProxyMain {
    public static void main(String[] args) {
        run();
    }

    /**
     *
     * aop with built-in reflection:Proxy#newProxyInstance , InvocationHandler#invoke
     * Attention:
     * 1.
     * one must implement the target interface;if not,it throws an exception
     *
     * 2.
     * It's slower
     *
     * 3.
     * It may cause Full GC,and method info was stored in method Area Of JVM.
     * It's advice to set a larger method area in jvm argument option
     */
    public static void run() {
        Class[] proxyInterfaces = new Class[]{IBusiness.class, IBusiness2.class};
        LogInvocationHandler logInvocationHandler = new LogInvocationHandler(new Business());
        ClassLoader classLoader = Business.class.getClassLoader();
        IBusiness2 proxyBusinessInterface = (IBusiness2) Proxy.newProxyInstance(classLoader, proxyInterfaces, logInvocationHandler);
        proxyBusinessInterface.doJob2();

        IBusiness iBusiness = (IBusiness) proxyBusinessInterface;
        iBusiness.doJob();


    }
}