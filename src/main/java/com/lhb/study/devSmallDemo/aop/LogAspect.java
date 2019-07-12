package com.lhb.study.devSmallDemo.aop;

import com.lhb.study.devSmallDemo.annotation.MyMethodAnno;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by lianghuaibin on 2019/3/8 18:13
 **/
@Aspect //该注解标示该类为切面类
@Component //注入依赖
public class LogAspect {

    //标注该方法体为后置通知，当目标方法执行成功后执行该方法体
    @AfterReturning("within(com.lhb.study.devSmallDemo.aop..*) && @annotation(rl)")
    public void addLogSuccess(JoinPoint jp, MyMethodAnno rl){
        Object[] parames = jp.getArgs();//获取目标方法体参数
        for (int i = 0; i < parames.length; i++) {
            System.out.println(parames[i]);
        }
        System.out.println(jp.getSignature().getName());
        String className = jp.getTarget().getClass().toString();//获取目标类名
        System.out.println("className:" + className);
        className = className.substring(className.indexOf("com"));
        String signature = jp.getSignature().toString();//获取目标方法签名
        System.out.println("signature:" + signature);
    }
}
