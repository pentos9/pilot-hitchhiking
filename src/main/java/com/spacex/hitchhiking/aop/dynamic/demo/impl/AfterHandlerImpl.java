package com.spacex.hitchhiking.aop.dynamic.demo.impl;

import com.spacex.hitchhiking.aop.dynamic.demo.AfterHandler;
import com.spacex.hitchhiking.util.PrintUtil;

import java.lang.reflect.Method;

public class AfterHandlerImpl extends AfterHandler {
    @Override
    public void handleAfter(Object proxy, Method method, Object[] args) {
        PrintUtil.println(String.format("AfterHandlerImpl#handleAfter invoke ..."));
    }
}