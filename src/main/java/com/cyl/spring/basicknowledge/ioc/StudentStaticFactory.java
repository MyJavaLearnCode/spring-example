package com.cyl.spring.basicknowledge.ioc;

public class StudentStaticFactory {
    public static Student newInstance(int id,String name) {
        return new Student(id, name);
    }

    public Student newInstance1(int id,String name) {
        return new Student(id, name);
    }
}
