package com.spacex.hitchhiking.annotation.define;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomInt {
    public int minValue() default 0;

    public int maxValue() default 10000;
}
