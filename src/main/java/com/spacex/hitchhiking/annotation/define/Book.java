package com.spacex.hitchhiking.annotation.define;

import com.spacex.hitchhiking.annotation.enums.Priority;
import com.spacex.hitchhiking.annotation.enums.Status;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Book {

    String author() default "wolfbang";

    int price() default 20;

    Priority priority() default Priority.LOW;

    Status status() default Status.NOT_STARTED;
}
