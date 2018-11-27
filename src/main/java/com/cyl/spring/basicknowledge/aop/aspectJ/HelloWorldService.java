package com.cyl.spring.basicknowledge.aop.aspectJ;

public class HelloWorldService implements IHelloWorldService {
    @Override
    public void sayHello() {
        System.out.println("business code");
//        throw new RuntimeException("throw exception");
    }
}
