package com.cyl.spring.basicknowledge.depends;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependsTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/basicknowledge/depends/depends.xml");
        applicationContext.registerShutdownHook();
        DependentBean dependentBean = applicationContext.getBean(DependentBean.class);
        dependentBean.businessCode("haha");
    }
}
