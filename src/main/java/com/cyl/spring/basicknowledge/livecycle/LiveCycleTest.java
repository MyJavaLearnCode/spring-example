package com.cyl.spring.basicknowledge.livecycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LiveCycleTest {
    @Test
    public void test() {
        System.out.println("开始初始化容器");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/basicknowledge/livecycle/liveCycle.xml");
        System.out.println("初始化容器成功");
        System.out.println("获取person，并使用");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println("获取到person：" + person);
        System.out.println("开始关闭容器");
        ((ClassPathXmlApplicationContext) applicationContext).registerShutdownHook();
    }

}
