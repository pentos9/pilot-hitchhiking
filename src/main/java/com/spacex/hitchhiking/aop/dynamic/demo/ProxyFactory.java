package com.spacex.hitchhiking.aop.dynamic.demo;

import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyFactory {
    public static Object getProxy(Object target, List<AbstractInvocationHandler> handlers) {
        Object proxyObject = null;

        if (CollectionUtils.isNotEmpty(handlers)) {
            proxyObject = target;
            for (int i = 0; i < handlers.size(); i++) {
                handlers.get(i).setTarget(proxyObject);
                proxyObject = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handlers.get(i));
            }

            return proxyObject;
        }
        return target;
    }
}
