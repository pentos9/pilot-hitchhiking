package com.spacex.hitchhiking.aop.dynamic.demo;

import java.lang.reflect.Method;

public abstract class BeforeHandler extends AbstractInvocationHandler {

    public abstract void handleBefore(Object proxy, Method method, Object[] args);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        handleBefore(proxy, method, args);
        return method.invoke(getTarget(), args);
    }
}
