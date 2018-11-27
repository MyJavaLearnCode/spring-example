package com.cyl.spring.basicknowledge.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Basicbean {
    /**
     * 基本的bean使用
     */
    @Test
    public void basicDi() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/basicknowledge/ioc/basicDI.xml");
        Student student = (Student) applicationContext.getBean("basicBeanUse");
        System.out.println("学号：" + student.getId());
        System.out.println("姓名：" + student.getName());
    }

    /**
     * 获取applicationContext的几种方式
     */
    @Test
    public void getAppContextMethod() {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/basicknowledge/ioc/basicDI.xml");
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:\\JavaCode\\src\\spring\\ioc\\basicDI.com.cyl.xml");
    }

    /**
     * 获取省略id和name的简单配置bean
     */
    @Test
    public void getSimpleConfigBean() {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/basicknowledge/ioc/basicDI.xml");
        Student student = classPathXmlApplicationContext.getBean(Student.class);
        System.out.println(student.getId());
    }


    /**
     * 通过name定义bean
     */
    @Test
    public void getNameDefinedBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/basicknowledge/ioc/basicDI.xml");
        Student student1 = (Student) applicationContext.getBean("nameDefineBean");
        System.out.println(student1.getId());
        Student student2 = (Student) applicationContext.getBean("nameDefinedBean2");
        System.out.println(student2.getId());
//        获取通过alias标签定义别名定义的bean
        Student studentAlias = (Student) applicationContext.getBean("studentALias");
        System.out.println(studentAlias.getId());
    }
}
