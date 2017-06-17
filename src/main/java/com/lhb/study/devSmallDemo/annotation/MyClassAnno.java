package com.lhb.study.devSmallDemo.annotation;

import java.lang.annotation.*;

/**
 * @author lianghuaibin
 * @since 2017/6/17
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyClassAnno {
    public String value() default "class";
}
