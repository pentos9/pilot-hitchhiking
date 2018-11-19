package com.spacex.hitchhiking.annotation.cases.func.defaults;

public class Car implements Vehicle, FourWheer {
    @Override
    public void print() {
        System.out.println("Car ");
    }
}
