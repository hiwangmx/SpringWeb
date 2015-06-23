package com.star.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER, ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {

	String value();
	
}
