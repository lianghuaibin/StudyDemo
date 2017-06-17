package com.lhb.study.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 代理注解
 * @author lianghuaibin
 * @since 2017/3/21
 */
public class ProxyAnnotationUtil {

    /**
     * 获取自定义注解
     *
     * @return Annotation
     */
    public static Annotation getClassAnno(Object obj, Class<? extends Annotation> clazzAnno) throws ClassNotFoundException {
        Class clazz = getClazz(obj);
        return clazz.getAnnotation(clazzAnno);
    }
    public static Annotation getMethodAnno(Object obj, Class<? extends Annotation> clazzAnno, String method, Class<?>... parameterTypes) throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = getClazz(obj);
        return clazz.getMethod(method, parameterTypes).getAnnotation(clazzAnno);
    }
    /**
     * 在有可能被代理的情况下
     *
     * @return Class
     */
    public static Class<?> getClazz(Object obj) throws ClassNotFoundException {
        Class clazz = obj.getClass();
        if(clazz.getSimpleName().indexOf("BySpringCGLIB") > 0) {
            clazz = clazz.getSuperclass();
        } else if(clazz.getSimpleName().indexOf("Proxy") > 0) {
            clazz = Class.forName(obj.toString().substring(0, obj.toString().indexOf("@")));
        }
        return clazz;
    }
}
