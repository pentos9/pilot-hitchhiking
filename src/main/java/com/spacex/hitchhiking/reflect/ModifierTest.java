package com.spacex.hitchhiking.reflect;

import com.spacex.hitchhiking.reflect.bean.Goat;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Modifier;

public class ModifierTest {
    public static void main(String[] args) throws Exception {
        run();
    }

    public static void run() throws Exception {
        testClassName();
        testModifier();
        testPackage();
    }

    public static void testClassName() throws Exception {
        Goat goat = new Goat("Dolly");
        Class clazz = goat.getClass();
        System.out.println(StringUtils.equals("Goat", clazz.getSimpleName()));
        System.out.println(StringUtils.equals("com.spacex.hitchhiking.reflect.bean.Goat", clazz.getName()));
        System.out.println(StringUtils.equals("com.spacex.hitchhiking.reflect.bean.Goat", clazz.getCanonicalName()));
    }

    public static void testModifier() throws ClassNotFoundException {
        Class goatClass = Class.forName("com.spacex.hitchhiking.reflect.bean.Goat");
        Class animalClass = Class.forName("com.spacex.hitchhiking.reflect.bean.Animal");

        int goatModifier = goatClass.getModifiers();
        int animalModifier = animalClass.getModifiers();

        System.out.println(Modifier.isPublic(goatModifier));
        System.out.println(Modifier.isPublic(animalModifier));
    }


    public static void testPackage() {
        Class goatClass = Goat.class;
        Package goatClassPackage = goatClass.getPackage();
        System.out.println(goatClassPackage.getName());
        System.out.println(StringUtils.equals("com.spacex.hitchhiking.reflect.bean", goatClassPackage.getName()));

    }
}
