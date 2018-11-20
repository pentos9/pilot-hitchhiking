package com.spacex.hitchhiking.generic.generator;

import java.util.Random;

public class FruitGenerator implements Generator<Fruit> {

    private static final String[] fruits = new String[]{"Apple", "Pear", "Grape", "Orange"};

    @Override
    public Fruit next() {
        Random random = new Random();
        int randomIndex = random.nextInt(fruits.length);
        String fruitName = fruits[randomIndex];
        return new Fruit(fruitName);
    }
}
