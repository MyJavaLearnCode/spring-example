package com.cyl.spring.basicknowledge.scope;

public class Person {
    public Person() {
        System.out.println("构造方法执行");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    private String name;
    private int age;
    private float height;

}
