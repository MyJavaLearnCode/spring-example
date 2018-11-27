package com.cyl.spring.basicknowledge.aop.aspectJ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/basicknowledge/aop/aspectJ/simpleAop.xml");
        HelloWorldService ihelloWorldService = context.getBean("helloWorldService",HelloWorldService.class);
        ihelloWorldService.sayHello();
    }

}
