package com.spacex.hitchhiking.aop.dynamic.handler;

import com.spacex.hitchhiking.util.PrintUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler {

    private Object target;//which was proxied

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().equalsIgnoreCase("doJob")) {
            PrintUtil.println(String.format("LogInvocationHandler#invoke#doJob aspect feature,proxy root class:%s", proxy.getClass()));
        }

        Object result = method.invoke(target, args);
        return result;
    }

    public Object getTarget() {
        return target;
    }
}
