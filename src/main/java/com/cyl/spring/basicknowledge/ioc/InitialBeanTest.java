package com.cyl.spring.basicknowledge.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class InitialBeanTest {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/basicknowledge/ioc/initialBean.xml");
        System.out.println("默认无参构造器注入");
        Student student = applicationContext.getBean("noArgsConstructor",Student.class);
        System.out.println(student.getId());

        System.out.println("通过有参构造器注入");
        Student student1 = applicationContext.getBean("argsConstructor", Student.class);
        System.out.println(student1.getId());
        System.out.println(student1.getName());

        System.out.println("通过有参构造器注入，通过方法参数类型匹配");
        Student student5 = applicationContext.getBean("argsTypeConstructor", Student.class);
        System.out.println(student5.getId());
        System.out.println(student5.getName());

        System.out.println("通过有参构造器注入，通过方法参数名匹配");
        Student student6 = applicationContext.getBean("argsNameConstructor", Student.class);
        System.out.println(student6.getId());
        System.out.println(student6.getName());

        System.out.println("通过静态工厂方法实例化bean");
        Student student2 = applicationContext.getBean("staticFactoryMethodInitialBean", Student.class);
        System.out.println(student2.getId());
        System.out.println(student2.getName());

        System.out.println("通过实例工厂方法实例化bean");
        Student student3 = applicationContext.getBean("instanceFactoryMethodInitialBean", Student.class);
        System.out.println(student3.getId());
        System.out.println(student3.getName());

        System.out.println("通过setter注入list");
        Student studentSetterDiList = applicationContext.getBean("studentSetterDiList", Student.class);
        System.out.println(studentSetterDiList.getBooks());

        System.out.println("通过setter注入数组");
        Student studentSetterDiArray = applicationContext.getBean("studentSetterDiArray", Student.class);
        System.out.println(Arrays.toString(studentSetterDiArray.getClothes()));

        System.out.println("通过setter注入set");
        Student studentSetterDiSet = applicationContext.getBean("studentSetterDiSet", Student.class);
        System.out.println(studentSetterDiSet.getBankCard());

        System.out.println("通过setter注入map");
        Student studentSetterDiMap = applicationContext.getBean("studentSetterDiMap", Student.class);
        System.out.println(studentSetterDiMap.getKeyAndValue());

        System.out.println("通过setter注入null");
        Student studentSetterDiNull = applicationContext.getBean("studentSetterDiNull", Student.class);
        System.out.println(studentSetterDiNull.getName());
    }
}
