package com.cydeo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE}) //@Target meta annotation to annotate other annotations
//The Target annotation specifies which elements of our code can have annotations of the defined type
//ElementType.Type this annotation can annotate a class, enum, interface
//ElementType.METHOD this annotation can annotate a method
@Retention(RetentionPolicy.RUNTIME) // @Retention sets the visibility of the annotation to which it is applied
public @interface LoggingAnnotation {

}
