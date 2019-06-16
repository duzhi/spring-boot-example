package com.daimabaike.biz.sys.annotation;

import com.daimabaike.biz.sys.cons.SginEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SginAnot {
    SginEnum type() default SginEnum.ANY;//默认不需要签名
}
