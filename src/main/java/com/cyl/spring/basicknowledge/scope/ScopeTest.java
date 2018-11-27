package com.cyl.spring.basicknowledge.scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    @Test
    public void testSingletonBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/basicknowledge/scope/scope.xml");
        Person person1 = applicationContext.getBean("singletonPerson",Person.class);
        System.out.println(person1.getName());
        Person person2 = applicationContext.getBean("singletonPerson", Person.class);
        System.out.println(person2.getName());
    }

    @Test
    public void testLazyInit() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/basicknowledge/scope/lazyInit.xml");
    }

}
