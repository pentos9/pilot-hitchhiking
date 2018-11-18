package com.spacex.hitchhiking.annotation.cases.func.defaults;

public interface Vehicle {
    default void print() {
        System.out.println("I am a four wheeler!");
    }
}
