package com.lhb.study.devSmallDemo.annotation;

import java.lang.annotation.*;

/**
 * @author lianghuaibin
 * @since 2017/6/17
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyMethodAnno {
    String code() default "code";
    public String value() default "method";
}
