package com.spacex.hitchhiking.annotation.define.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.CLASS)
public @interface Contract {
    String value() default "";

    boolean pure() default false;

    String mutates() default "";
}
