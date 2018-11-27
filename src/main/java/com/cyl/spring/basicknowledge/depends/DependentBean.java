package com.cyl.spring.basicknowledge.depends;

public class DependentBean {
    public void init() {
        System.out.println("DependentBean初始化");
    }

    public void businessCode(String string) {
        System.out.println(string);
    }

    public void destory() {
        System.out.println("DependentBean被销毁");
    }
}
