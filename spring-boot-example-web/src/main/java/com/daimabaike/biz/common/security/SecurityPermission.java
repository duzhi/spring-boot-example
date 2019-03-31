package com.daimabaike.biz.common.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityPermission {

	@AliasFor("value")
	String[] name() default {};

	@AliasFor("name")
	String[] value() default {};

}
