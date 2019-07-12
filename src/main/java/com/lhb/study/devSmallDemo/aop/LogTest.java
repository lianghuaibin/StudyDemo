package com.lhb.study.devSmallDemo.aop;

import com.lhb.study.devSmallDemo.annotation.MyMethodAnno;

/**
 * Created by lianghuaibin on 2019/3/8 18:15
 **/
public class LogTest {

    @MyMethodAnno(code = "0001",value = "method1")
    public void getAdminLogById(Integer id) {
        System.out.println("=============");
    }

    public static void main(String[] args) {
        LogTest test = new LogTest();
        test.getAdminLogById(123);
    }

}
