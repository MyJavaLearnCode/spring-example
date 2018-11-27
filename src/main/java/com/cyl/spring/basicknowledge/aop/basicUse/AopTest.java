package com.cyl.spring.basicknowledge.aop.basicUse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/basicknowledge/aop/basicUse/simpleAop.xml");
        IhelloWorldService ihelloWorldService = context.getBean("helloWorldService",IhelloWorldService.class);
        ihelloWorldService.sayHello();
    }

}
