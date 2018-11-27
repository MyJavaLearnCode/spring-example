package com.cyl.spring.basicknowledge.methodInjection;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;
import java.util.Arrays;

public class PrinterReplacer implements MethodReplacer{
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("被替换方法的对象" + obj);
        System.out.println("替换的方法逻辑");
        System.out.println("被替换的方法名" + method);
        System.out.println("被替换的方法传入的参数" + Arrays.toString(args));
        //注意不能再通过反射调用，会产生循环调用
//        method.invoke(obj,args);
        return null;
    }
}
