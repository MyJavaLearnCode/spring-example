package com.cyl.spring.basicknowledge.livecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;
import java.util.Arrays;

/**
 * InstantiationAwareBeanPostProcessorAdapter方法
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    public MyInstantiationAwareBeanPostProcessor() {
        super();
        System.out.println("MyInstantiationAwareBeanPostProcessor constructor");
    }

    /**
     * 实例化bean之前调用
     */
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        System.out.println("org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        System.out.println("beanClass:" + beanClass);
        System.out.println("beanName:" + beanName);
        return super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    /**
     * 实例化bean之后调用
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
        System.out.println("bean:" + bean);
        System.out.println("beanName:" + beanName);
        return super.postProcessAfterInstantiation(bean, beanName);
    }

    /**
     *
     * 设置某个属性时调用
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor.postProcessPropertyValues");
        System.out.println("pvs:" + pvs);
        System.out.println("pds:"+Arrays.toString(pds));
        System.out.println("bean:"+ bean);
        System.out.println("beanName"+ beanName);
        return super.postProcessPropertyValues(pvs, pds, bean, beanName);
    }
}
