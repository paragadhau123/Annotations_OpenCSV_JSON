package com.bridgelabz.annotationcsvjson.model;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface MethodInfo {
    String author() default "parag";

    String date();

    int revision() default 1;

    String comments();
}

public class AnnotationExample {
    @Deprecated
    @MethodInfo(comments = "Deprecated Method", date = "3/09/2020")
    public static void oldMethod() {
        System.out.println("Old Method Don't Use It.");
    }

    public static void annotationExample() {
        try {
            for (Method method : AnnotationExample.class.getMethods()) {
                if (method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method '" + method + "': " + anno);
                        }
                        MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                        if (methodAnno.revision() == 1) {
                            System.out.println("Method with Revision no 1 = " + method);
                        }
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            }
        } catch (SecurityException se) {
            se.printStackTrace();
        }
    }

    @Override
    @MethodInfo(author = "parag", comments = "Main Method", date = "3/9/2020", revision = 1)
    public String toString() {
        return "Overridden toString Method";
    }
}
