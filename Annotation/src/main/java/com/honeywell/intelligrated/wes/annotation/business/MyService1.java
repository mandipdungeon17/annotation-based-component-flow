package com.honeywell.intelligrated.wes.annotation.business;

import com.honeywell.intelligrated.wes.annotation.annotation.MyAnnotation;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@MyAnnotation
@Service
public class MyService1 {

    @Autowired MyService2 myService2;
    @MyAnnotation
    public void method1(String input1, int input2) {
        myService2.method1(input1, input2);
        System.out.println("Executing method1 with inputs: " + input1 + ", " + input2);
    }

//    @MyAnnotation
    public void method2(int input1, boolean input2) {
        ((MyService1) AopContext.currentProxy()).
                method3(true, 123.45);
        System.out.println("Executing method2 with inputs: " + input1 + ", " + input2);
    }

    @MyAnnotation
    public void method3(boolean input1, double input2) {
        myService2.method2(678, false);
        System.out.println("Executing method3 with inputs: " + input1 + ", " + input2);
    }
}