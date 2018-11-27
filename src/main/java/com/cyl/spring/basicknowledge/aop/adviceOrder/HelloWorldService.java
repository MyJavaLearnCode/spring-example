package com.cyl.spring.basicknowledge.aop.adviceOrder;

public class HelloWorldService implements IhelloWorldService {
    @Override
    public void sayHello() {
        System.out.println("business code");
//        throw new RuntimeException("throw exception");
    }
}
