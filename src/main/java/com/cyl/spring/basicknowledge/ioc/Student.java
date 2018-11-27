package com.cyl.spring.basicknowledge.ioc;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    public Student() {
        System.out.println("默认无参构造器");
    }

    public Student(int id, String name) {
        System.out.println("自定义有参构造器");
        this.id = id;
        this.name = name;
    }

    private int id = 0;
    private String name = "";
    private List<String> books;
    private String[] clothes;
    private Set<String> bankCard;
    private Map<String, Integer> keyAndValue;


    public Map<String, Integer> getKeyAndValue() {
        return keyAndValue;
    }

    public void setKeyAndValue(Map<String, Integer> keyAndValue) {
        this.keyAndValue = keyAndValue;
    }


    public Set<String> getBankCard() {
        return bankCard;
    }

    public void setBankCard(Set<String> bankCard) {
        this.bankCard = bankCard;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public String[] getClothes() {
        return clothes;
    }

    public void setClothes(String[] clothes) {
        this.clothes = clothes;
    }
}
