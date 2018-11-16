package com.spacex.hitchhiking.annotation.cases;

import com.spacex.hitchhiking.annotation.cases.func.DispatcherService;
import com.spacex.hitchhiking.annotation.cases.func.FunctionalBean;

public class FunctionalTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        DispatcherService dispatcherService = () -> System.out.println("dispatcher business logic ");
        dispatcherService.dispatcher();
        dispatcherService.dispatcherWithDowngrade();

        FunctionalBean.doLogic("Args-1", "Args-2", 1L, new Bean());
    }
}
