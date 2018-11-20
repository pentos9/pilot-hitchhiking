package com.spacex.hitchhiking.generic.convertor;


import java.util.Collection;

public class GenericTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String[] stringArray = new String[]{"MacBook", "iPad", "Mac Air", "iPhone"};
        Collection collection = ConvertorUtil.fromArrayToCollection(stringArray);
        System.out.println(collection);

        Integer[] integerArray = new Integer[]{1, 2, 4, 5, 6, 7, 10};
        Collection integerCollection = ConvertorUtil.fromArrayToCollection(integerArray);
        System.out.println(integerCollection);

    }
}
