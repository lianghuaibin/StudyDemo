package com.lhb.study.devSmallDemo.annotation;

import com.lhb.study.util.ProxyAnnotationUtil;

/**
 * @author lianghuaibin
 * @since 2017/6/17
 */
@MyClassAnno("1313")
public class Test {

    @MyMethodAnno(code = "0001",value = "method1")
    public void init(Integer i){
        System.out.println("Test init...");
    }
    public static void main(String[] args) {
        Test test = new Test();
        try {
            MyClassAnno anno = (MyClassAnno) ProxyAnnotationUtil.getClassAnno(test,MyClassAnno.class);
            System.out.println(anno.value());
            MyMethodAnno myMethodAnno = (MyMethodAnno) ProxyAnnotationUtil.getMethodAnno(test,MyMethodAnno.class,"init",Integer.class);
            System.out.println(myMethodAnno.code()+"\t"+myMethodAnno.value());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
