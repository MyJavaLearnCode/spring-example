package com.cyl.spring.basicknowledge.depends;

public class ResourceBean {
    public void init() {
        System.out.println("ResourceBean初始化");
    }

    public void destory() {
        System.out.println("ResourceBean被销毁");
    }

}
