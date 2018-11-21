package com.spacex.hitchhiking.generic.generator;

public class GeneratorTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Generator<Fruit> fruitGenerator = new FruitGenerator();
        Fruit fruit = fruitGenerator.next();
        System.out.println(fruit);

        RandomeStringGenerator randomeStringGenerator = new RandomeStringGenerator();
        String random = randomeStringGenerator.next();
        System.out.println(random);
    }
}
