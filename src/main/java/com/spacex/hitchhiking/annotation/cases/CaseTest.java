package com.spacex.hitchhiking.annotation.cases;

import com.spacex.hitchhiking.annotation.define.OnClick;
import com.spacex.hitchhiking.annotation.define.Book;
import com.spacex.hitchhiking.annotation.define.framework.Service;
import com.spacex.hitchhiking.annotation.define.Todo;
import com.spacex.hitchhiking.annotation.enums.Priority;
import com.spacex.hitchhiking.annotation.enums.Status;
import com.spacex.hitchhiking.util.PrintUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class CaseTest {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        doTraverseMethod(CaseTest.class, Todo.class, Book.class, OnClick.class);
        doTraverseClass(ServiceTest.class, Service.class);
    }

    public static void doTraverseClass(Class clazz, Class<? extends Annotation>... annotationClasses) {
        if (clazz == null || ArrayUtils.isEmpty(annotationClasses)) {
            return;
        }

        for (Class<? extends Annotation> annotationClass : annotationClasses) {
            if (clazz.isAnnotationPresent(annotationClass)) {
                PrintUtil.println(String.format("[Yes] method %s, annotated with %s", clazz.getName(), annotationClass.getName()));
            } else {
                PrintUtil.println(String.format("[No] method %s, not annotated with %s", clazz.getName(), annotationClass.getName()));
            }
        }
    }

    @Book()
    public static void doTraverseMethod(Class clazz, Class<? extends Annotation>... annotationClasses) {

        Method[] methods = clazz.getMethods();

        if (ArrayUtils.isEmpty(methods)) {
            return;
        }

        traverseMethod(methods, annotationClasses);
    }

    public static void traverseMethod(Method[] methods, Class<? extends Annotation>... annotationClasses) {
        if (ArrayUtils.isEmpty(methods)) {
            return;
        }

        for (Method method : methods) {
            isAnnotatedWithTargetAnnotation(method, annotationClasses);
        }
    }

    public static void isAnnotatedWithTargetAnnotation(Method method, Class<? extends Annotation>... annotationClasses) {

        if (ArrayUtils.isEmpty(annotationClasses)) {
            return;
        }

        for (Class<? extends Annotation> annotation : annotationClasses) {
            if (method.isAnnotationPresent(annotation)) {
                PrintUtil.println(String.format("[Yes] method %s, annotated with %s", method.getName(), annotation.getName()));
            } else {
                PrintUtil.println(String.format("[No] method %s, not annotated with %s", method.getName(), annotation.getName()));
            }
        }

    }

    @Todo(priority = Priority.MEDUIM, author = "wolf", status = Status.START)
    @Book()
    @OnClick
    public static void incompleteMethod() {
        PrintUtil.println("Let's do something now!");
    }
}
