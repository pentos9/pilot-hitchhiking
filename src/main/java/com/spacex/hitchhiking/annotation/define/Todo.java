package com.spacex.hitchhiking.annotation.define;


import com.spacex.hitchhiking.annotation.enums.Priority;
import com.spacex.hitchhiking.annotation.enums.Status;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Todo {
    Priority priority() default Priority.LOW;

    String author() default "wolfbang";

    Status status() default Status.NOT_STARTED;

}
