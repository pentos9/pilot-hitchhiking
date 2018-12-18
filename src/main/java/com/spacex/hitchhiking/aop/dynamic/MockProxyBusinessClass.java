package com.spacex.hitchhiking.aop.dynamic;

import com.spacex.hitchhiking.aop.dynamic.handler.LogInvocationHandler;
import com.spacex.hitchhiking.aop.dynamic.interfaces.IBusiness;
import com.spacex.hitchhiking.aop.dynamic.interfaces.IBusiness2;

import java.lang.reflect.Method;

/**
 * JDK creates a proxy class something like this
 */
public class MockProxyBusinessClass implements IBusiness, IBusiness2 {

    private LogInvocationHandler logInvocationHandler;

    public MockProxyBusinessClass(LogInvocationHandler logInvocationHandler) {
        this.logInvocationHandler = logInvocationHandler;
    }

    @Override
    public void doJob() {
        try {
            Method method = logInvocationHandler.getTarget().getClass().getMethod("doJob", null);
            logInvocationHandler.invoke(this, method, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void doJob2() {
        try {
            Method method = logInvocationHandler.getTarget().getClass().getMethod("doJob2", null);
            logInvocationHandler.invoke(this, method, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    public static void main(String[] args) {
        LogInvocationHandler handler = new LogInvocationHandler(new Business());
        new MockProxyBusinessClass(handler).doJob();
        new MockProxyBusinessClass(handler).doJob2();

    }
}
