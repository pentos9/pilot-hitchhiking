package com.spacex.hitchhiking.aop.dynamic.demo;

import java.lang.reflect.InvocationHandler;

public abstract class AbstractInvocationHandler implements InvocationHandler {
    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
