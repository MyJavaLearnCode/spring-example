package com.cyl.spring.basicknowledge.aop.basicUse;

public class HelloWorldService implements IhelloWorldService {
    @Override
    public void sayHello() {
        System.out.println("business code");
//        throw new RuntimeException("throw exception");
    }
}
