package com.spacex.hitchhiking.annotation.cases.func;

@FunctionalInterface
public interface DispatcherService {

    void dispatcher();

    default void dispatcherWithDowngrade() {
        System.out.println("[DispatcherService - default] down grade now");
    }
}
