package com.spacex.hitchhiking.aop.dynamic.demo;

import java.lang.reflect.Method;

public abstract class AfterHandler extends AbstractInvocationHandler {

    public abstract void handleAfter(Object proxy, Method method, Object[] args);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(getTarget(), args);
        handleAfter(proxy, method, args);
        return result;
    }
}
