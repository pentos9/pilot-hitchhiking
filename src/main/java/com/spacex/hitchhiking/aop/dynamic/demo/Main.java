package com.spacex.hitchhiking.aop.dynamic.demo;

import com.google.common.collect.Lists;
import com.spacex.hitchhiking.aop.dynamic.demo.beans.TaskService;
import com.spacex.hitchhiking.aop.dynamic.demo.beans.TaskServiceImpl;
import com.spacex.hitchhiking.aop.dynamic.demo.impl.AfterHandlerImpl;
import com.spacex.hitchhiking.aop.dynamic.demo.impl.BeforeHandlerImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        TaskService taskService = new TaskServiceImpl();
        BeforeHandler beforeHandler = new BeforeHandlerImpl();
        AfterHandler afterHandler = new AfterHandlerImpl();

        List<AbstractInvocationHandler> handlers = Lists.newArrayList();
        handlers.add(beforeHandler);
        handlers.add(afterHandler);
        TaskService proxy = (TaskService) ProxyFactory.getProxy(taskService, handlers);
        proxy.doJob();
    }
}
