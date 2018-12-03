package com.spacex.hitchhiking.generic.interfaces;

public interface Moveable {
    void setX(int x);

    void setY(int y);

    int getX();

    int getY();

    default void moveVertically() {
        System.out.println("do#moveVertically");
    }

    default void moveHorizontally() {
        System.out.println("do#moveHorizontally");
    }

}
