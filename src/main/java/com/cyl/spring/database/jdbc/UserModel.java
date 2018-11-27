package com.cyl.spring.database.jdbc;

public class UserModel {
    private int id;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    private String myName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
