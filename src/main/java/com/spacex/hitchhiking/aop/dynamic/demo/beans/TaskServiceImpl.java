package com.spacex.hitchhiking.aop.dynamic.demo.beans;

import com.spacex.hitchhiking.util.PrintUtil;

public class TaskServiceImpl implements TaskService {
    @Override
    public void doJob() {
        PrintUtil.println(String.format("TaskServiceImpl#doJob ..."));
    }
}