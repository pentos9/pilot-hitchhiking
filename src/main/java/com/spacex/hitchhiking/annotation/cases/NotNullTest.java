package com.spacex.hitchhiking.annotation.cases;

import com.spacex.hitchhiking.annotation.define.ParamIsNotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class NotNullTest {
    public static void main(String[] args) throws Exception {
        run();
    }

    public static void run() throws Exception {
        Bean bean = new Bean();
        paramIsNotNull(bean);
    }

    public static void paramIsNotNull(Object modle) throws Exception {
        if (modle == null) {
            return;
        }

        Field[] fields = modle.getClass().getDeclaredFields();

        for (Field field : fields) {
            ParamIsNotNull paramIsNotNull = field.getAnnotation(ParamIsNotNull.class);
            if (paramIsNotNull != null) {
                String name = field.getName();
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                Method method = modle.getClass().getMethod("get" + name);
                Object value = method.invoke(modle);

                if (value == null) {
                    throw new IllegalArgumentException(String.format("%s can not be null!", field.getName()));
                }

            }
        }
    }
}
