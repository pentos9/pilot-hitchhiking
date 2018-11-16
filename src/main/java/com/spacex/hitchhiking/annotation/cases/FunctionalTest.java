package com.spacex.hitchhiking.annotation.cases;

import com.spacex.hitchhiking.annotation.cases.func.DispatcherService;

public class FunctionalTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        DispatcherService dispatcherService = new DispatcherService() {
            @Override
            public void dispatcher() {
                System.out.println("dispatcher business logic ");
            }
        };
        dispatcherService.dispatcher();
        dispatcherService.dispatcherWithDowngrade();
    }
}
