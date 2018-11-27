package com.cyl.spring.basicknowledge.methodInjection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MethodInjectTest {
    @Test
    public void lookupMethod() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/basicknowledge/methodInjection/lookupMethodInjection.xml");
        HelloApi helloApi1 = applicationContext.getBean("helloApi1",HelloApi.class);
        helloApi1.sayHello();
        helloApi1 = applicationContext.getBean("helloApi1",HelloApi.class);
        helloApi1.sayHello();
        System.out.println("prototype sayHello");
        HelloApi helloApi2 = applicationContext.getBean("helloApi2", HelloApi.class);
        helloApi2.sayHello();
        helloApi2 = applicationContext.getBean("helloApi2", HelloApi.class);
        helloApi2.sayHello();
    }

    @Test
    public void replacerMethod() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/basicknowledge/methodInjection/methodReplaceInjection.xml");
        Printer printer =  applicationContext.getBean("printer",Printer.class);
        System.out.println("对象实例：" + printer);
        printer.print("将被替换");
    }

}
