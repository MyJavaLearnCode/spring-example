package com.cyl.spring.basicknowledge.livecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor接口方法
 */
public class MyBeanPostProcessor implements BeanPostProcessor{
    public MyBeanPostProcessor() {
        super();
        System.out.println("MyBeanPostProcessor constructor");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("org.springframework.beans.factory.config.BeanPostProcessor.postProcessBeforeInitialization");
        System.out.println("could modify prop");
        System.out.println("bean:"+bean.toString());
        System.out.println("beanName:" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("org.springframework.beans.factory.config.BeanPostProcessor.postProcessAfterInitialization");
        System.out.println("could modify prop");
        System.out.println("bean:"+bean.toString());
        System.out.println("beanName:" + beanName);
        return bean;
    }
}
