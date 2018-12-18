package com.spacex.hitchhiking.aop.cglib;

import com.spacex.hitchhiking.util.PrintUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class BookServiceCglib implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equalsIgnoreCase("add")) {
            PrintUtil.println("BookServiceCglib#intercept add addBook log...");
        }

        methodProxy.invokeSuper(obj, objects);
        return null;
    }
}
