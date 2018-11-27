package com.cyl.spring.basicknowledge.livecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public MyBeanFactoryPostProcessor() {
        super();
        System.out.println("MyBeanFactoryPostProcessor constructor");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("org.springframework.beans.factory.config.BeanFactoryPostProcessor.postProcessBeanFactory");
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("person");
        beanDefinition.getPropertyValues().addPropertyValue("phone", "110");
    }
}
