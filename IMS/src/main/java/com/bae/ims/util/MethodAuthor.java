package com.bae.ims.util;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Custom annotation to document the author of a method or constructor.
 * 
 * @author Alex Dawson
 * @version 0.1 22/11/2016
 *
 */
@Documented
@Retention(CLASS)
@Target({ METHOD, CONSTRUCTOR })
public @interface MethodAuthor {
	String author();
}
