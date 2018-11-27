package com.cyl.spring.basicknowledge.livecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;


/**
 * 调用Bean自身的方法和Bean级生命周期接口方法
 */
public class Person  implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{
    private String name;
    private String address;
    private int phone;

    private BeanFactory beanFactory;
    private String beanName;

    public Person() {
        System.out.println("constructor call.");
    }

    /**
     * BeanFactoryAware
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("org.springframework.beans.factory.BeanFactoryAware.setBeanFactory");
        System.out.println("beanFactory:" + beanFactory);
        this.beanFactory = beanFactory;
    }

    /**
    * BeanNameAware
    * */
    @Override
    public void setBeanName(String name) {
        System.out.println("org.springframework.beans.factory.BeanNameAware.setBeanName");
        System.out.println("beanName:" + name);
        this.beanName = name;
    }

    /**
     * BeanNameAware
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("org.springframework.beans.factory.DisposableBean.destroy");
    }

    /**
     * InitializingBean
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("org.springframework.beans.factory.InitializingBean.afterPropertiesSet");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("inject property:name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("inject property:address");
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        System.out.println("inject property:phone");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("Person[address:%s,name:%s,phone:%s]",address,name,phone);
    }

    /**
     * init-method
     */
    public void initMethod() {
        System.out.println("init-method");
    }

    /**
     * destory-method
     */
    public void destoryMethod() {
        System.out.println("destory-method");
    }
}
