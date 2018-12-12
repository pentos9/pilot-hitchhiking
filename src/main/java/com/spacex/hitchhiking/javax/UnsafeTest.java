package com.spacex.hitchhiking.javax;

import com.spacex.hitchhiking.annotation.cases.Bean;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {
    public static void main(String[] args) {
        run();
    }

    private static Unsafe getUnsafeInstance() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }

    public static void run() {
        try {
            Unsafe unsafe = getUnsafeInstance();
            Long valueOffset = unsafe.objectFieldOffset(Bean.class.getDeclaredField("name"));
            System.out.println(valueOffset);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
