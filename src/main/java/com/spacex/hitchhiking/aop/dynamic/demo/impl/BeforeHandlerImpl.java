package com.spacex.hitchhiking.aop.dynamic.demo.impl;

import com.spacex.hitchhiking.aop.dynamic.demo.BeforeHandler;
import com.spacex.hitchhiking.util.PrintUtil;

import java.lang.reflect.Method;

public class BeforeHandlerImpl extends BeforeHandler {
    @Override
    public void handleBefore(Object proxy, Method method, Object[] args) {
        PrintUtil.println(String.format("BeforeHandlerImpl#handleBefore invoke..."));
    }
}
